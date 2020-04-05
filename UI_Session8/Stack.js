function Stack() {
  this.items = [];
}

Stack.prototype.push = function (element) {
  this.items.push(element);
}

Stack.prototype.pop = function (element) {
  let data = this.items[this.items.length - 1];
  this.items.pop();
  return data;
}

Stack.prototype.display = function () {
  console.log("\n");
  console.log(this.items);
  console.log("\n");
}

var s = new Stack();
console.log(s.pop());
s.push(3);
s.push(2);
s.push(1);
s.push(0);
s.display();
console.log(s.pop());
s.display();