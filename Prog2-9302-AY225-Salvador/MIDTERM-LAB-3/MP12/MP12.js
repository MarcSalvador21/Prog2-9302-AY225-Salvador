const fs = require('fs');
const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.question("Enter CSV file path: ", function(filePath) {
    try {
        const data = fs.readFileSync(filePath, "utf8");
        const lines = data.trim().split("\n").map(l => l.split(","));

        // Compute column widths
        const colWidths = [];
        lines.forEach(row => {
            row.forEach((val, i) => {
                if (!colWidths[i] || val.length > colWidths[i]) colWidths[i] = val.length;
            });
        });

        // Print formatted table
        lines.forEach(row => {
            let line = row.map((val, i) => val.padEnd(colWidths[i], ' ')).join('  ');
            console.log(line);
        });

    } catch (err) {
        console.log("Error reading file: " + err.message);
    }
    rl.close();
});