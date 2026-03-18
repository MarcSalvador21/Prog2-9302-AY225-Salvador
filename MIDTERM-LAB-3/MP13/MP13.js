const fs = require('fs');
const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.question("Enter CSV file path: ", function(filePath) {
    try {
        const data = fs.readFileSync(filePath, "utf8");
        const lines = data.trim().split("\n");

        lines.forEach((line, index) => {
            const values = line.split(",");
            const hasMissing = values.some(v => v.trim() === "");
            if (hasMissing) {
                console.log(`Row ${index + 1}: ${values.join(" | ")}`);
            }
        });

    } catch (err) {
        console.log("Error reading file: " + err.message);
    }
    rl.close();
});