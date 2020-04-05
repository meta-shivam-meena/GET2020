/**
 * function representing node class.
 * Node represents an element of linked list.
 */
function Node(data) {
  this.data = data;
  this.next = null;
}

/**
 * This function represents a linked list class.
 */
function SinglyLinkedList() {
  this.head = null;
  this.size = 0;
}

/**
 * Add an element at start
 */
SinglyLinkedList.prototype.addAtFirst = function (data) {
  let newNode = new Node(data);
  newNode.next = this.head;
  this.head = newNode;
  this.size++;
}

/**
 * Add an element at last
 */
SinglyLinkedList.prototype.addAtLast = function (data) {
  let newNode = new Node(data);
  if (!this.head) {
    this.head = newNode;
  } else {
    let current = this.head;
    while (current.next != null) {
      current = current.next;
    }
    current.next = newNode;
  }
  this.size++;
}

/**
 * Add an element at any index
 * It returns false if data cannot be added due to bad index
 * that is if index is greter than size of list.
 */
SinglyLinkedList.prototype.addAtIndex = function (index, data) {
  if (index > this.size) {
    return false;
  }
  if (index == 0) {
    this.addAtStart(data);
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
    current.next = newNode;
  }
}

/**
 * Remove an element from start
 * Returns the element which is removed
 */
SinglyLinkedList.prototype.removeFirst = function () {
  if (!this.head) {
    return null;
  }
  this.size--;
  let data = this.head.data;
  this.head = this.head.next;
  return data;
}

/**
 * Remove an element from last
 * Returns the element which is removed
 */
SinglyLinkedList.prototype.removeLast = function () {
  if (!this.head) {
    return null;
  }
  this.size--;
  if (this.head.next == null) {
    let data = this.head.data;
    this.head = null;
    return data;
  } else {
    let current = this.head.next;
    let prev = this.head;
    while (current.next != null) {
      prev = current;
      current = current.next;
    }
    let data = current.data;
    prev.next = null;
    return data;
  }
}

/**
 * Remove an element from any index
 * Returns the element which is removed
 * If index is not present in list, null is returned
 */
SinglyLinkedList.prototype.removeIndex = function (index) {
  if (index > this.size) {
    return null;
  }
  if (index == 0) {
    return this.removeFirst();
  } else if (index == this.size - 1) {
    return this.removeLast();
  } else {
    size--;
    let current = this.head;
    let counter = 1;
    while (counter != index) {
      current = current.next;
      counter++;
    }
    let data = current.next.data;
    current.next = current.next.next;
    return data;
  }
}

/**
 * It returns index of first occurence of data
 * Returns -1 if data is not present in list
 */
SinglyLinkedList.prototype.indexOf = function (data) {
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
SinglyLinkedList.prototype.display = function () {
  let current = this.head;
  console.log("\n");
  console.log("Size" + this.size);
  while (current) {
    console.log(current.data);
    current = current.next;
  }
  console.log("\n");
}

var list = new SinglyLinkedList();
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