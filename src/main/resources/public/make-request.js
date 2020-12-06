let otherEventType = document.getElementById("otherEventType");
let eventDropdown = document.getElementById("eventDropdown");
let otherEventTypeInput = document.getElementById("otherEventTypeInput");
let cost = document.getElementById("costInput");
let otherGradeType = document.getElementById("otherGradeType");
let gradeDropdown = document.getElementById("gradeDropdown");
let otherGradeTypeInput = document.getElementById("otherGradeTypeInput");

eventDropdown.addEventListener("change", (change) => {
  handleOtherToggle(eventDropdown, otherEventType, otherEventTypeInput);
});

gradeDropdown.addEventListener("change", (change) => {
  handleOtherToggle(gradeDropdown, otherGradeType, otherGradeTypeInput);
});

function handleOtherToggle(dropdown, type, input) {

  if (dropdown.value == "OTHER") {
    type.style.display = "block";
    input.required = true;
  }
  else {
    type.style.display = "none";
    type.required = false;
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