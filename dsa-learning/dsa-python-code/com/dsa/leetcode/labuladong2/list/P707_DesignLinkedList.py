class Node:
    def __init__(self, val: int):
        self.val = val
        self.prev = None
        self.next = None


class MyLinkedList:

    def __init__(self):
        self.head = Node(None)
        self.tail = Node(None)
        self.size = 0
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, index: int) -> int:
        if self.isNotPositionIndex(index):
            return -1
        return self.getNode(index).val

    def addAtHead(self, val: int) -> None:
        self.addAtIndex(0, val)

    def addAtTail(self, val: int) -> None:
        self.addAtIndex(self.size, val)

    def addAtIndex(self, index: int, val: int) -> None:
        if self.isPositionIndex(index):
            cur = self.getNode(index)
            prev = cur.prev
            newNode = Node(val)
            prev.next = newNode
            cur.prev = newNode
            newNode.prev = prev
            newNode.next = cur
            self.size = self.size + 1
        if index == self.size:
            cur = self.tail
            prev = cur.prev
            newNode = Node(val)
            prev.next = newNode
            cur.prev = newNode
            newNode.prev = prev
            newNode.next = cur
            self.size = self.size + 1

    def deleteAtIndex(self, index: int) -> None:
        if self.isPositionIndex(index):
            cur = self.getNode(index)
            prev = cur.prev
            next = cur.next
            prev.next = next
            next.prev = prev
            self.size = self.size - 1

    def getNode(self, index: int) -> Node:
        cur = self.head
        for i in range(0, index + 1):
            cur = cur.next
        return cur

    def isNotPositionIndex(self, index: int) -> bool:
        return not self.isPositionIndex(index)

    def isPositionIndex(self, index: int) -> bool:
        return index >= 0 and index < self.size
