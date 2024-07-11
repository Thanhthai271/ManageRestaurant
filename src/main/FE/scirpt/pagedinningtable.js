document.getElementById('fetchButton').addEventListener('click', function() {
    fetch('http://localhost:8082/dinningTable')  // Thay URL này bằng URL thực tế của API DinningTable của bạn
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok ' + response.statusText);
            }
            return response.json();
        })
        .then(data => {
            console.log(data);  // In ra console để kiểm tra dữ liệu
            const resultDiv = document.getElementById('result');
            resultDiv.innerHTML = '';

            data.forEach(item => {
                const div = document.createElement('div');
                div.innerHTML = `
                    <p><strong>Table ID:</strong> ${item.tableId}</p>
                    <p><strong>Seats:</strong> ${item.seats}</p>
                    <p><strong>Table Number:</strong> ${item.tableNumber}</p>
                    <p><strong>Dinning Table ID:</strong> ${item.dinningTableId}</p>
                    <p><strong>Status:</strong> ${item.status}</p>
                    <hr>
                `;
                resultDiv.appendChild(div);
            });
        })
        .catch(error => {
            console.error('Error fetching data:', error);
            document.getElementById('result').innerHTML = 'Error fetching data';
        });
});
