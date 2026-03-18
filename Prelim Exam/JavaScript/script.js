/*
 Programmer: Marc Timothy Salvador - 23-0191-615
*/

let students = [];

// Fetch the CSV file
fetch("MOCK_DATA.csv")
    .then(res => {
        if (!res.ok) throw new Error("CSV not found");
        return res.text();
    })
    .then(text => parseCSV(text))
    .catch(err => {
        console.error("FETCH ERROR:", err);
        alert("Failed to load MOCK_DATA.csv. Make sure it's in the same folder and you're using a local server.");
    });

// Parse CSV into student objects
function parseCSV(csv) {
    const lines = csv.trim().split("\n");

    // Remove header
    const header = lines.shift();

    students = lines.map(line => {
        const c = line.split(",");
        return {
            id: c[0],
            name: c[1] + " " + c[2],
            grade: c[6]
        };
    });

    render();
}

// Render the table
function render() {
    const body = document.getElementById("tableBody");

    // Map students into table rows
    body.innerHTML = students.map((s, i) => `
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.grade}</td>
            <td>
                <button onclick="deleteStudent(${i})">Delete</button>
            </td>
        </tr>
    `).join('');
}

// Add a new student
function addStudent() {
    const id = document.getElementById("id").value;
    const name = document.getElementById("name").value;
    const grade = document.getElementById("grade").value;

    if (!id || !name || !grade) {
        alert("Please fill all fields");
        return;
    }

    students.push({ id, name, grade });
    render();

    // Clear input fields
    document.getElementById("id").value = "";
    document.getElementById("name").value = "";
    document.getElementById("grade").value = "";
}

// Delete a student by index
function deleteStudent(i) {
    if (confirm(`Delete ${students[i].name}?`)) {
        students.splice(i, 1);
        render();
    }
}
