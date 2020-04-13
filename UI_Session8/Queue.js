function Queue() {
  this.items = [];
}

Queue.prototype.enqueue = function (element) {
  this.items.push(element);
}

Queue.prototype.dequeue = function () {
  let data = this.items[0];
  this.items.shift();
  return data;
}

Queue.prototype.display = function () {
  console.log("\n");
  console.log(this.items);
  console.log("\n");
}

var q = new Queue();
console.log(q.dequeue());
q.enqueue(1);
q.enqueue(2);
q.enqueue(3);
q.display();
console.log(q.dequeue());
q.display();