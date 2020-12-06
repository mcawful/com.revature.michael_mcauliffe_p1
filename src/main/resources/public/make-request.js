let otherEventType = document.getElementById("otherEventType");
let eventDropdown = document.getElementById("eventDropdown");
let otherEventTypeInput = document.getElementById("otherEventTypeInput");
let cost = document.getElementById("costInput");
let otherGradeType = document.getElementById("otherGradeType");
let gradeDropdown = document.getElementById("gradeDropdown");
let otherGradeTypeInput = document.getElementById("otherGradeTypeInput");
let startDateInput = document.getElementById("startDateInput");
let endDateInput = document.getElementById("endDateInput");
let startDate = new Date();

window.addEventListener("load", (event) => {
  setEarliestStartDate(startDate, startDateInput);
});

startDateInput.addEventListener("change", (event) => {
  let endDate = new Date(startDateInput.value);
  let currentEndDate = new Date(endDateInput.value);
  if(currentEndDate > endDate) endDate = currentEndDate;
  endDate.setDate(endDate.getDate() + 1);
  endDateInput.setAttribute("min", dateToString(endDate));
  endDateInput.value = dateToString(endDate);
  endDateInput.disabled = false;
});

eventDropdown.addEventListener("change", (change) => {
  handleOtherToggle(eventDropdown, otherEventType, otherEventTypeInput);
});

gradeDropdown.addEventListener("change", (change) => {
  handleOtherToggle(gradeDropdown, otherGradeType, otherGradeTypeInput);
});

function dateToString(date) {
  let dd = date.getDate();
  let mm = date.getMonth() + 1; //January is 0!
  let yyyy = date.getFullYear();
  if (dd < 10) {
    dd = '0' + dd
  }
  if (mm < 10) {
    mm = '0' + mm
  }

  return date = yyyy + '-' + mm + '-' + dd;
}

function setEarliestStartDate(date, input) {
  date.setDate(date.getDate() + 7);
  input.setAttribute("min", dateToString(date));
}

function handleOtherToggle(dropdown, type, input) {

  if (dropdown.value == "OTHER") {
    type.style.display = "block";
    type.required = true;
  }
  else {
    type.style.display = "none";
    type.required = false;
    input.value = null;
  }
}

// currency formatting logic
var currencyInput = document.getElementById("costInput");
var currency = 'USD' // https://www.currency-iso.org/dam/downloads/lists/list_one.xml

// format inital value
onBlur({ target: currencyInput })

// bind event listeners
currencyInput.addEventListener('focus', onFocus)
currencyInput.addEventListener('blur', onBlur)

function localStringToNumber(s) {
  return Number(String(s).replace(/[^0-9.-]+/g, ""))
}

function onFocus(e) {
  var value = e.target.value;
  e.target.value = value ? localStringToNumber(value) : ''
}

function onBlur(e) {
  var value = e.target.value

  var options = {
    maximumFractionDigits: 2,
    currency: currency,
    style: "currency",
    currencyDisplay: "symbol"
  }

  e.target.value = (value || value === 0)
    ? localStringToNumber(value).toLocaleString(undefined, options)
    : ''
}