package data_structures_basics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DataStructuresBasicsTest {

    private static final int FIRST_NODE_INPUT = 10;
    private static final int FIRST_NODE_OUTPUT = 10;
    private static final int SECOND_NODE_INPUT = 20;
    private static final int LINKED_NODE_OUTPUT = 20;

    private static final int EMPTY_SIZE_OUTPUT = 0;
    private static final int FAILURE_OUTPUT = -1;
    private static final int FIRST_TAIL_INPUT = 10;
    private static final int SECOND_TAIL_INPUT = 20;
    private static final int HEAD_INPUT = 5;
    private static final int DUPLICATE_TAIL_INPUT = 10;
    private static final int INSERTED_SIZE_OUTPUT = 4;
    private static final int INSERTED_HEAD_OUTPUT = 5;
    private static final int FIRST_DELETE_INPUT = 10;
    private static final int FIRST_DELETE_HEAD_OUTPUT = 5;
    private static final int FIRST_DELETE_SIZE_OUTPUT = 3;
    private static final int ABSENT_DELETE_INPUT = 99;
    private static final int EMPTY_FIRST_DELETE_INPUT = 5;
    private static final int EMPTY_SECOND_DELETE_INPUT = 20;
    private static final int EMPTY_THIRD_DELETE_INPUT = 10;

    private static final int STACK_FIRST_INPUT = 10;
    private static final int STACK_SECOND_INPUT = 20;
    private static final int STACK_THIRD_INPUT = 30;
    private static final int STACK_REUSE_INPUT = 40;
    private static final int STACK_PEEK_OUTPUT = 30;
    private static final int STACK_POP_FIRST_OUTPUT = 30;
    private static final int STACK_POP_SECOND_OUTPUT = 40;
    private static final int STACK_POP_THIRD_OUTPUT = 20;
    private static final int STACK_POP_FOURTH_OUTPUT = 10;
    private static final int STACK_INSERTED_SIZE_OUTPUT = 3;

    private static final int QUEUE_FIRST_INPUT = 10;
    private static final int QUEUE_SECOND_INPUT = 20;
    private static final int QUEUE_THIRD_INPUT = 30;
    private static final int QUEUE_REUSE_INPUT = 40;
    private static final int QUEUE_PEEK_OUTPUT = 10;
    private static final int QUEUE_DEQUEUE_FIRST_OUTPUT = 10;
    private static final int QUEUE_DEQUEUE_SECOND_OUTPUT = 20;
    private static final int QUEUE_DEQUEUE_THIRD_OUTPUT = 30;
    private static final int QUEUE_DEQUEUE_FOURTH_OUTPUT = 40;
    private static final int QUEUE_INSERTED_SIZE_OUTPUT = 3;

    private static void assertNodeCases(String subject) {
        Node firstNode = new Node(FIRST_NODE_INPUT);
        assertEquals(FIRST_NODE_OUTPUT, firstNode.getValue(),
                subject + " should preserve the first node value");
        assertNull(firstNode.getNext(),
                subject + " should leave the first node link absent");

        Node secondNode = new Node(SECOND_NODE_INPUT);
        firstNode.setNext(secondNode);
        assertEquals(LINKED_NODE_OUTPUT, firstNode.getNext().getValue(),
                subject + " should traverse the linked node value");
        assertNull(secondNode.getNext(),
                subject + " should leave the second node link absent");
    }

    private static void assertLinkedListCases(String subject) {
        LinkedList list = new LinkedList();
        assertTrue(list.isEmpty(), subject + " should report an empty initialized list");
        assertEquals(EMPTY_SIZE_OUTPUT, list.size(),
                subject + " should report zero elements in an empty list");
        assertEquals(FAILURE_OUTPUT, list.getHead(),
                subject + " should return the failure indicator for an empty list");

        list.insertTail(FIRST_TAIL_INPUT);
        list.insertTail(SECOND_TAIL_INPUT);
        list.insertHead(HEAD_INPUT);
        list.insertTail(DUPLICATE_TAIL_INPUT);
        assertEquals(INSERTED_SIZE_OUTPUT, list.size(),
                subject + " should count elements inserted at both ends");
        assertEquals(INSERTED_HEAD_OUTPUT, list.getHead(),
                subject + " should expose the head after insertion at both ends");

        assertTrue(list.delete(FIRST_DELETE_INPUT),
                subject + " should delete the first matching value");
        assertEquals(FIRST_DELETE_HEAD_OUTPUT, list.getHead(),
                subject + " should retain the head after deleting the first matching value");
        assertEquals(FIRST_DELETE_SIZE_OUTPUT, list.size(),
                subject + " should reduce the size after deleting the first matching value");

        assertFalse(list.delete(ABSENT_DELETE_INPUT),
                subject + " should return failure for an absent value");
        assertEquals(FIRST_DELETE_HEAD_OUTPUT, list.getHead(),
                subject + " should retain the traversal after an absent value");
        assertEquals(FIRST_DELETE_SIZE_OUTPUT, list.size(),
                subject + " should retain the size after an absent value");

        assertTrue(list.delete(EMPTY_FIRST_DELETE_INPUT),
                subject + " should delete the remaining head while emptying the list");
        assertTrue(list.delete(EMPTY_SECOND_DELETE_INPUT),
                subject + " should delete the remaining middle value while emptying the list");
        assertTrue(list.delete(EMPTY_THIRD_DELETE_INPUT),
                subject + " should delete the remaining tail while emptying the list");
        assertTrue(list.isEmpty(), subject + " should report empty after all values are deleted");
        assertEquals(EMPTY_SIZE_OUTPUT, list.size(),
                subject + " should report zero elements after all values are deleted");
        assertEquals(FAILURE_OUTPUT, list.getHead(),
                subject + " should return the failure indicator after all values are deleted");
    }

    private static void assertStackCases(String subject) {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty(), subject + " should report an empty initialized stack");
        assertEquals(EMPTY_SIZE_OUTPUT, stack.size(),
                subject + " should report zero elements in an empty stack");
        assertEquals(FAILURE_OUTPUT, stack.peek(),
                subject + " should return the failure indicator when peeking an empty stack");
        assertEquals(FAILURE_OUTPUT, stack.pop(),
                subject + " should return the failure indicator when popping an empty stack");

        stack.push(STACK_FIRST_INPUT);
        stack.push(STACK_SECOND_INPUT);
        stack.push(STACK_THIRD_INPUT);
        assertEquals(STACK_PEEK_OUTPUT, stack.peek(),
                subject + " should peek at the most recently pushed value");
        assertEquals(STACK_INSERTED_SIZE_OUTPUT, stack.size(),
                subject + " should not mutate size while peeking");

        assertEquals(STACK_POP_FIRST_OUTPUT, stack.pop(),
                subject + " should pop the prior top before reuse");
        stack.push(STACK_REUSE_INPUT);
        assertEquals(STACK_POP_SECOND_OUTPUT, stack.pop(),
                subject + " should pop the reused top first");
        assertEquals(STACK_POP_THIRD_OUTPUT, stack.pop(),
                subject + " should preserve LIFO order after reuse");
        assertEquals(STACK_POP_FOURTH_OUTPUT, stack.pop(),
                subject + " should pop the oldest value last");
        assertTrue(stack.isEmpty(), subject + " should report empty after all values are popped");
        assertEquals(EMPTY_SIZE_OUTPUT, stack.size(),
                subject + " should report zero elements after all values are popped");

        assertEquals(FAILURE_OUTPUT, stack.pop(),
                subject + " should return failure after the stack is emptied");
        assertTrue(stack.isEmpty(),
                subject + " should remain empty after a failed pop");
    }

    private static void assertQueueCases(String subject) {
        Queue queue = new Queue();
        assertTrue(queue.isEmpty(), subject + " should report an empty initialized queue");
        assertEquals(EMPTY_SIZE_OUTPUT, queue.size(),
                subject + " should report zero elements in an empty queue");
        assertEquals(FAILURE_OUTPUT, queue.peek(),
                subject + " should return the failure indicator when peeking an empty queue");
        assertEquals(FAILURE_OUTPUT, queue.dequeue(),
                subject + " should return the failure indicator when dequeuing an empty queue");

        queue.enqueue(QUEUE_FIRST_INPUT);
        queue.enqueue(QUEUE_SECOND_INPUT);
        queue.enqueue(QUEUE_THIRD_INPUT);
        assertEquals(QUEUE_PEEK_OUTPUT, queue.peek(),
                subject + " should peek at the first enqueued value");
        assertEquals(QUEUE_INSERTED_SIZE_OUTPUT, queue.size(),
                subject + " should not mutate size while peeking");

        assertEquals(QUEUE_DEQUEUE_FIRST_OUTPUT, queue.dequeue(),
                subject + " should dequeue the first value before reuse");
        queue.enqueue(QUEUE_REUSE_INPUT);
        assertEquals(QUEUE_DEQUEUE_SECOND_OUTPUT, queue.dequeue(),
                subject + " should preserve FIFO order after reuse");
        assertEquals(QUEUE_DEQUEUE_THIRD_OUTPUT, queue.dequeue(),
                subject + " should dequeue the next value in FIFO order");
        assertEquals(QUEUE_DEQUEUE_FOURTH_OUTPUT, queue.dequeue(),
                subject + " should dequeue the reused value last");
        assertTrue(queue.isEmpty(), subject + " should report empty after all values are dequeued");
        assertEquals(EMPTY_SIZE_OUTPUT, queue.size(),
                subject + " should report zero elements after all values are dequeued");

        assertEquals(FAILURE_OUTPUT, queue.dequeue(),
                subject + " should return failure after the queue is emptied");
        assertTrue(queue.isEmpty(),
                subject + " should remain empty after a failed dequeue");
    }

    @Test
    void testNodeInit() {
        assertNodeCases("node init");
    }

    @Test
    void testNodeGetValue() {
        assertNodeCases("node getValue");
    }

    @Test
    void testNodeGetNext() {
        assertNodeCases("node getNext");
    }

    @Test
    void testNodeSetNext() {
        assertNodeCases("node setNext");
    }

    @Test
    void testLinkedListInit() {
        assertLinkedListCases("linked list init");
    }

    @Test
    void testLinkedListGetHead() {
        assertLinkedListCases("linked list getHead");
    }

    @Test
    void testLinkedListInsertHead() {
        assertLinkedListCases("linked list insertHead");
    }

    @Test
    void testLinkedListInsertTail() {
        assertLinkedListCases("linked list insertTail");
    }

    @Test
    void testLinkedListDelete() {
        assertLinkedListCases("linked list delete");
    }

    @Test
    void testLinkedListIsEmpty() {
        assertLinkedListCases("linked list isEmpty");
    }

    @Test
    void testLinkedListSize() {
        assertLinkedListCases("linked list size");
    }

    @Test
    void testStackInit() {
        assertStackCases("stack init");
    }

    @Test
    void testStackPush() {
        assertStackCases("stack push");
    }

    @Test
    void testStackPop() {
        assertStackCases("stack pop");
    }

    @Test
    void testStackPeek() {
        assertStackCases("stack peek");
    }

    @Test
    void testStackIsEmpty() {
        assertStackCases("stack isEmpty");
    }

    @Test
    void testStackSize() {
        assertStackCases("stack size");
    }

    @Test
    void testQueueInit() {
        assertQueueCases("queue init");
    }

    @Test
    void testQueueEnqueue() {
        assertQueueCases("queue enqueue");
    }

    @Test
    void testQueueDequeue() {
        assertQueueCases("queue dequeue");
    }

    @Test
    void testQueuePeek() {
        assertQueueCases("queue peek");
    }

    @Test
    void testQueueIsEmpty() {
        assertQueueCases("queue isEmpty");
    }

    @Test
    void testQueueSize() {
        assertQueueCases("queue size");
    }
}
