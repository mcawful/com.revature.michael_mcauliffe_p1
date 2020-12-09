let otherEventType = document.getElementById("otherEventType");
let eventDropdown = document.getElementById("eventDropdown");
let otherEventTypeInput = document.getElementById("otherEventTypeInput");
let cost = document.getElementById("costInput");
let otherGradeType = document.getElementById("otherGradeType");
let gradeDropdown = document.getElementById("gradeDropdown");
let otherGradeTypeInput = document.getElementById("otherGradeTypeInput");
let startDateInput = document.getElementById("startDateInput");
let endDateInput = document.getElementById("endDateInput");
let otherPassingGradeType = document.getElementById("otherPassingGrade");
let otherPassingGradeInput = document.getElementById("otherPassingGradeInput");
let startDate = new Date();

// calendar init onload handler
window.addEventListener("load", (event) => {
  setEarliestStartDate(startDate, startDateInput);
});

// dynamic available dates selector
startDateInput.addEventListener("change", (event) => {

  let endDate = new Date(startDateInput.value);
  let currentEndDate = new Date(endDateInput.value);

  endDate.setDate(endDate.getDate() + 1);
  currentEndDate.setDate(currentEndDate.getDate() + 1);
  endDateInput.setAttribute("min", dateToString(endDate));
  endDateInput.value = dateToString(endDate);

  if (currentEndDate > endDate) {
    endDateInput.value = dateToString(currentEndDate);
  }
  endDateInput.disabled = false;
});

// listener for 'Other' event dropdown
// makes 'Other' custom event input visable
eventDropdown.addEventListener("change", (change) => {
  handleOtherToggle(eventDropdown, otherEventType, otherEventTypeInput);
});

// listener for 'Other' grade dropdown
// makes 'Other' custom grade and passing grade inputs visable
gradeDropdown.addEventListener("change", (change) => {
  handleOtherToggle(gradeDropdown, otherGradeType, otherGradeTypeInput);
  handleOtherToggle(gradeDropdown, otherPassingGradeType, otherPassingGradeInput);
});

// date to string converter for calendar inputs
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

// sets first available calendar date to one week from today
function setEarliestStartDate(date, input) {
  date.setDate(date.getDate() + 7);
  input.setAttribute("min", dateToString(date));
}

// handles visibility toggle for 'Other' inputs
function handleOtherToggle(dropdown, type, input) {

  if (dropdown.value == "OTHER") {
    type.style.display = "block";
    input.required = true;
  }
  else if (dropdown.value != "OTHER") {
    type.style.display = "none";
    input.required = false;
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