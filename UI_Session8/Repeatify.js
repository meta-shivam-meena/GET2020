String.prototype.repeatify = function (numberOfTimes) {
  var repeatedString = '';
  for (var i = 0; i < numberOfTimes; i++) {
    repeatedString += this.toString();
  }
  return repeatedString;
}

console.log('hello'.repeatify(3));