/**
 * function representing node class.
 * Node represents an element of linked list.
 */
function Node(data) {
  this.data = data;
  this.prev = null;
  this.next = null;
}

/**
 * This function represents a linked list class.
 */
function DoublyLinkedList() {
  this.head = null;
  this.tail = null;
  this.size = 0;
}

/**
 * Add an element at start
 */
DoublyLinkedList.prototype.addAtFirst = function (data) {
  let newNode = new Node(data);
  if (!this.head) {
    this.tail = newNode;
  } else {
    this.head.prev = newNode;
    newNode.next = this.head;
  }
  this.head = newNode;
  this.size++;
}

/**
 * Add an element at last
 */
DoublyLinkedList.prototype.addAtLast = function (data) {
  let newNode = new Node(data);
  if (!this.head) {
    this.head = newNode;
  } else {
    this.tail.next = newNode;
    newNode.prev = this.tail;
  }
  this.tail = newNode;
  this.size++;
}

/**
 * Add an element at any index
 * It returns false if data cannot be added due to bad index
 * that is if index is greter than size of list.
 */
DoublyLinkedList.prototype.addAtIndex = function (index, data) {
  if (index > this.size) {
    return false;
  }
  if (index == 0) {
    this.addAtFirst(data);
  } else if (index == this.size) {
    this.addAtLast(data);
  } else {
    this.size++;
    let current = this.head;
    let counter = 1;
    let newNode = new Node(data);
    while (counter != index) {
      current = current.next;
      counter++;
    }
    newNode.next = current.next;
    newNode.prev = current;
    current.next.prev = newNode;
    current.next = newNode;
  }
  return true;
}

/**
 * Remove an element from start
 * Returns the element which is removed
 */
DoublyLinkedList.prototype.removeFirst = function () {
  if (!this.head) {
    return null;
  }
  this.size--;
  let data = this.head.data;
  this.head = this.head.next;
  if (this.head) {
    this.head.prev = null;
  } else {
    this.tail = null;
  }
  return data;
}

/**
 * Remove an element from last
 * Returns the element which is removed
 */
DoublyLinkedList.prototype.removeLast = function () {
  if (!this.tail) {
    return null;
  }
  this.size--;
  let data = this.tail.data;
  this.tail = this.tail.prev;
  if (this.tail) {
    this.tail.next = null;
  } else {
    this.head = null;
  }
  return data;
}

/**
 * Remove an element from any index
 * Returns the element which is removed
 * If index is not present in list, null is returned
 */
DoublyLinkedList.prototype.removeIndex = function (index) {
  if (index >= this.size) {
    return null;
  }
  if (index == 0) {
    return this.removeFirst();
  }
  if (index == this.size - 1) {
    return this.removeLast();
  }
  let current = this.head.next;
  let counter = 1;
  while (counter != index) {
    current = current.next;
    counter++;
  }
  current.prev.next = current.next;
  current.next.prev = current.prev;
  this.size--;
  return current.data;
}

/**
 * It returns index of first occurence of data
 * Returns -1 if data is not present in list
 */
DoublyLinkedList.prototype.indexOf = function (data) {
  let current = this.head;
  let index = 0;
  while (current) {
    if (current.data == data) {
      return index; 
    }
    current = current.next;
    index++;
  }
  return -1;
}

/**
 * It displays the list
 */
DoublyLinkedList.prototype.display = function () {
  let current = this.head;
  console.log("\n");
  console.log("Size" + this.size);
  while (current) {
    console.log(current.data);
    current = current.next;
  }
  console.log("\n");
}

var list = new DoublyLinkedList();
list.addAtFirst(1);
list.display();
list.addAtLast(3);
list.display();
list.addAtIndex(1, 2);
list.display();
list.addAtLast(4);
list.display();
console.log(list.indexOf(2))
console.log(list.removeLast());
list.display();
console.log(list.removeFirst());
list.display();
console.log(list.removeIndex(1));
list.display();