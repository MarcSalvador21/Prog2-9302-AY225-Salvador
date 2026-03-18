const fs = require('fs');

const filePath = "../data.csv"; // CSV in parent folder
const columnName = "Exam";      // change this to any column you want

fs.readFile(filePath, 'utf8', (err, data) => {
    if (err) {
        console.log('Error reading CSV:', err.message);
        return;
    }

    const lines = data.trim().split('\n');
    const headers = lines[0].split(',');
    const columnIndex = headers.findIndex(h => h.trim().toLowerCase() === columnName.trim().toLowerCase());

    if (columnIndex === -1) {
        console.log('Column not found.');
        return;
    }

    const frequency = {};
    for (let i = 1; i < lines.length; i++) {
        const values = lines[i].split(',');
        const key = values[columnIndex] ? values[columnIndex].trim() : '';
        frequency[key] = (frequency[key] || 0) + 1;
    }

    console.log(`Frequency for column "${columnName}":`);
    for (const [key, count] of Object.entries(frequency)) {
        console.log(`${key} : ${count}`);
    }
});