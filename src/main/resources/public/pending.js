
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
    let table = document.getElementById("employeePendingTitle");

    let tableRow1 = document.createElement("tr");
    let eventTypeCol = document.createElement("td");
    let eventLocationCol = document.createElement("td");
    let descriptionCol = document.createElement("td");
    let costCol = document.createElement("td");
    let reimburseCol = document.createElement("td");

    tableRow1.appendChild(eventTypeCol);

    eventTypeCol.innerHTML = request.eventType;
}

function addApproverRequests() {

}