Producer-Consumer
--------------------------------
--------------------------------

This is a simple Producer-Consumer example in SCJ. It uses two managed threads, one Producer and one Consumer. The single mission holds an intance of
Buffer, which holds the bounded buffer. The two threads communicate with the mission to produce and consumer data from the buffer. The Producer
waits when the buffer is full. The Consumer waits when the buffer is empty. When a thread alters the buffer, they notify the other thread.
