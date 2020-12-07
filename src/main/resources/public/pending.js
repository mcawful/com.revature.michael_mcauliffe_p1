
window.onload = function () {
    let xhr = new XMLHttpRequest();
    const url = "/pending/view";
    xhr.onreadystatechange = function () {
        console.log(xhr.readyState);
        switch (xhr.readyState) {

            case 1:
                // add logging
                break;
            case 2:
                // add logging
                break;
            case 3:
                // add logging
                break;
            case 4:
                // add logging
                if (xhr.status === 200) {
                    let requestList = JSON.parse(xhr.responseText);
                    requestList.forEach(element => {
                        addEmployeeRequest(element);
                    });
                }
                break;

        }
    }

    xhr.open("GET", url, true);
    xhr.send();

}


function addEmployeeRequest(request) {
    let table = document.getElementById("employeePendingTable");

    let tableRow1 = document.createElement("tr");
    let eventTypeCol = document.createElement("td");
    let eventLocationCol = document.createElement("td");
    let descriptionCol = document.createElement("td");
    let costCol = document.createElement("td");
    let reimburseCol = document.createElement("td");

    tableRow1.appendChild(eventTypeCol);
    tableRow1.appendChild(eventLocationCol);
    tableRow1.appendChild(descriptionCol);
    tableRow1.appendChild(costCol);
    tableRow1.appendChild(reimburseCol);
    table.appendChild(tableRow1);

    eventTypeCol.innerHTML = request.eventType;
    eventLocationCol.innerHTML = request.location;
    descriptionCol.innerHTML = request.description;
    costCol.innerHTML = request.cost;
    reimburseCol.innerHTML = request.reimbursement;

    eventTypeCol.className = "table-style";
    eventLocationCol.className = "table-style";
    descriptionCol.className = "table-style";
    costCol.className = "table-style";
    reimburseCol.className = "table-style";
    tableRow1.className = "table-style";
}

function addApproverRequests() {

}