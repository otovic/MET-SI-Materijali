const data = [
    { name: 'John', age: 30, city: 'New York' },
    { name: 'Jane', age: 25, city: 'London' },
    { name: 'Bob', age: 35, city: 'Paris' }
  ];

function generateTable() {
    const table = document.getElementById('myTable');
    
    for (let i = 0; i < data.length; i++) {
      const row = table.insertRow(i);
      const cell1 = row.insertCell(0);
      const cell2 = row.insertCell(1);
      const cell3 = row.insertCell(2);
  
      cell1.innerHTML = data[i].name;
      cell2.innerHTML = data[i].age;
      cell3.innerHTML = data[i].city;
    }
  }