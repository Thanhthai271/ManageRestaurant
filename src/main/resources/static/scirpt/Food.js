document.addEventListener('DOMContentLoaded', function() {
    // Bắt sự kiện click vào liên kết Food
    const foodLink = document.getElementById('food-link');
    if (foodLink) {
        foodLink.addEventListener('click', async function(event) {
            event.preventDefault(); // Ngăn chặn hành vi mặc định của liên kết

            try {
                // Gọi API để lấy dữ liệu
                const foodData = await fetchFoodData();

                if (foodData) {
                    // Hiển thị nội dung chính cho phần Food
                    const foodContent = document.getElementById('food-content');
                    const dashboardContent = document.getElementById('dashboard-content');

                    if (foodContent && dashboardContent) {
                        foodContent.classList.remove('hidden');
                        dashboardContent.classList.add('hidden');

                        // Hiển thị dữ liệu đã lấy được
                        displayFoodData(foodData);
                    } else {
                        console.error('Không tìm thấy phần tử food-content hoặc dashboard-content.');
                    }
                } else {
                    console.log('Không có dữ liệu hoặc có lỗi xảy ra khi lấy dữ liệu.');
                }
            } catch (error) {
                console.error('Lỗi khi gọi API lấy dữ liệu món ăn:', error);
            }
        });
    } else {
        console.error('Không tìm thấy phần tử food-link.');
    }
});

// Hàm để gọi API lấy dữ liệu món ăn
async function fetchFoodData() {
    try {
        const response = await fetch('http://localhost:8082/food');
        if (!response.ok) {
            throw new Error('Lỗi mạng khi gọi API');
        }
        const foodData = await response.json();
        return foodData;
    } catch (error) {
        console.error('Lỗi khi lấy dữ liệu món ăn:', error);
        return null;
    }
}

// Hàm để lấy thông tin món ăn theo ID
async function getFoodItemById(id) {
    try {
        const response = await fetch(`http://localhost:8082/food/${id}`);
        if (!response.ok) {
            throw new Error('Lỗi khi lấy thông tin món ăn');
        }
        const foodItem = await response.json();
        return foodItem;
    } catch (error) {
        console.error('Lỗi khi lấy thông tin món ăn:', error);
        return null;
    }
}

// Hàm để cập nhật món ăn
async function updateFoodItem(id, updatedData) {
    try {
        const response = await fetch(`http://localhost:8082/food/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(updatedData),
        });
        if (!response.ok) {
            throw new Error('Lỗi khi cập nhật món ăn');
        }
        return true; // Trả về true nếu cập nhật thành công
    } catch (error) {
        console.error('Lỗi khi cập nhật món ăn:', error);
        return false; // Trả về false nếu có lỗi xảy ra
    }
}

// Hàm để xóa món ăn
async function deleteFoodItem(id) {
    try {
        const response = await fetch(`http://localhost:8082/food/${id}`, {
            method: 'DELETE'
        });
        if (!response.ok) {
            throw new Error('Lỗi khi xóa món ăn');
        }
        return true; // Trả về true nếu xóa thành công
    } catch (error) {
        console.error('Lỗi khi xóa món ăn:', error);
        return false; // Trả về false nếu có lỗi xảy ra
    }
}

// Hàm để hiển thị dữ liệu món ăn trong bảng
function displayFoodData(foodData) {
    const foodTableBody = document.getElementById('food-table-body');
    if (foodTableBody) {
        foodTableBody.innerHTML = ''; // Xóa các dòng trong bảng hiện tại

        // Tạo hàng dữ liệu cho từng món ăn
        foodData.forEach(foodItem => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${foodItem.name}</td>
                <td>${foodItem.price}</td>
                <td>${foodItem.categoryFood || '-'}</td>
                <td>${foodItem.categoryDrink || '-'}</td>
                <td>
                    <button class="edit-food" data-id="${foodItem.id}">Edit</button>
                    <button class="delete-food" data-id="${foodItem.id}">Delete</button>
                </td>
            `;
            foodTableBody.appendChild(row);
        });

        // Bắt sự kiện click nút Edit và Delete
        foodTableBody.addEventListener('click', async function(event) {
            const target = event.target;

            // Kiểm tra nếu nút edit được click
            if (target.classList.contains('edit-food')) {
                // Lấy hàng (row) chứa nút edit
                const row = target.closest('tr');
                if (row) {
                    // Lấy ID của món ăn từ data-id của nút edit
                    const id = row.querySelector('.edit-food').getAttribute('data-id');

                    // Kiểm tra xem ID có tồn tại không
                    if (id) {
                        // Lấy thông tin chi tiết của món ăn theo ID
                        const foodItem = await getFoodItemById(id);
                        if (foodItem) {
                            // Hiển thị giao diện sửa đổi thông tin món ăn
                            const updatedData = prompt('Nhập thông tin mới cho món ăn', JSON.stringify(foodItem));
                            if (updatedData) {
                                const parsedData = JSON.parse(updatedData);
                                const updated = await updateFoodItem(id, parsedData);
                                if (updated) {
                                    // Nếu cập nhật thành công, cập nhật lại dữ liệu trên giao diện
                                    const updatedFoodData = await fetchFoodData();
                                    if (updatedFoodData) {
                                        displayFoodData(updatedFoodData);
                                    }
                                }
                            }
                        } else {
                            console.error('Không tìm thấy món ăn có ID:', id);
                        }
                    } else {
                        console.error('Không tìm thấy ID của món ăn.');
                    }
                } else {
                    console.error('Không tìm thấy hàng chứa nút edit.');
                }
            }

            // Xử lý sự kiện xóa món ăn
            else if (target.classList.contains('delete-food')) {
                const id = target.getAttribute('data-id');
                const confirmed = confirm('Bạn có chắc chắn muốn xóa món ăn này?');
                if (confirmed) {
                    const deleted = await deleteFoodItem(id);
                    if (deleted) {
                        // Nếu xóa thành công, cập nhật lại dữ liệu trên giao diện
                        const updatedFoodData = await fetchFoodData();
                        if (updatedFoodData) {
                            displayFoodData(updatedFoodData);
                        }
                    }
                }
            }
        });
    } else {
        console.error('Không tìm thấy phần tử food-table-body.');
    }
}

document.addEventListener('DOMContentLoaded', function() {
    const addFoodButton = document.querySelector('.add-food');
    if (addFoodButton) {
        addFoodButton.addEventListener('click', async function(event) {
            event.preventDefault(); // Ngăn chặn hành vi mặc định của nút

            const foodName = prompt('Nhập tên món ăn:');
            const foodPrice = parseFloat(prompt('Nhập giá tiền:'));
            const categoryFood = prompt('Nhập danh mục thực phẩm:');
            const categoryDrink = prompt('Nhập danh mục đồ uống:');

            if (foodName && !isNaN(foodPrice) && categoryFood && categoryDrink) {
                const newFoodData = {
                    name: foodName,
                    price: foodPrice,
                    categoryFood: categoryFood,
                    categoryDrink: categoryDrink
                };

                // Gọi API để thêm món ăn mới
                const added = await addFoodItem(newFoodData);
                if (added) {
                    // Nếu thêm thành công, cập nhật lại dữ liệu món ăn
                    const updatedFoodData = await fetchFoodData();
                    if (updatedFoodData) {
                        displayFoodData(updatedFoodData);
                    }
                }
            } else {
                console.error('Vui lòng nhập đầy đủ thông tin.');
            }
        });
    }
});

// Hàm để thêm món ăn mới
async function addFoodItem(newFoodData) {
    try {
        const response = await fetch('http://localhost:8082/food', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(newFoodData), // Gửi object JSON mới
        });
        const responseData = await response.json();
        if (!response.ok) {
            throw new Error(responseData.message || 'Lỗi khi thêm món ăn');
        }
        return true; // Trả về true nếu thêm thành công
    } catch (error) {
        console.error('Lỗi khi thêm món ăn:', error.message);
        return false; // Trả về false nếu có lỗi xảy ra
    }
}


// Bắt sự kiện click nút Add Food
const addFoodButton = document.querySelector('.add-food');
if (addFoodButton) {
    addFoodButton.addEventListener('click', async function() {
        const foodName = prompt('Nhập tên món ăn:');
        const foodPrice = parseFloat(prompt('Nhập giá tiền:'));
        const categoryFood = prompt('Nhập danh mục thực phẩm:');
        const categoryDrink = prompt('Nhập danh mục đồ uống:');

        if (foodName && !isNaN(foodPrice) && categoryFood && categoryDrink) {
            const newFoodData = {
                name: foodName,
                price: foodPrice,
                categoryFood: categoryFood,
                categoryDrink: categoryDrink
            };

            const added = await addFoodItem(newFoodData);
            if (added) {
                // Nếu thêm thành công, cập nhật lại dữ liệu trên giao diện
                const updatedFoodData = await fetchFoodData();
                if (updatedFoodData) {
                    displayFoodData(updatedFoodData);
                }
            }
        } else {
            console.error('Vui lòng nhập đầy đủ thông tin.');
        }
    });
}


