// Luis Felipe Garcia de Souza (Leader), Diana Afanasyev, Jessie Moszkowicz, Barry Penner
// COMP 5511 - Principles of Data Structures
// Fall 2023
// Assignment 1 Question 5

public class LList {

    public Element head;
    public int  length;

    public LList() {
        // constructor
        this.head = null;
        this.length = 0;
    }

    public void push(String data) {
        // add new element to head (top) of linked list
        Element element = new Element(data);
        if (this.head != null) {
            element.next = this.head;
        }
        this.head = element;
        this.length++;
        return;
    }

    public void pop() {
        // delete element at head (top) of linked list
        // print text message to stdout if list is empty
        if (this.head == null) {
            System.out.printf("Error: pop: list is already empty.\n");
            return;
        }
        this.head = this.head.next;
        this.length--;
        return;
    }

    public String toString(String annotate) {
        // displays contents of the list by walking from head to tail
        // two options, one with no annotation and one with an arrow
        // pointing to the head element. Swap comments to change.
        StringBuffer output = new StringBuffer();
        Element element = this.head;
        int ctr = 0;

        switch (annotate) {

        case "annotate":
            // output with list head marked
            if (this.length == 0) {
                return "empty list: nothing to print.";
            } else {
                output.append("-----------------------------------\n");
                do {
                    if (ctr == this.length-1) {
                        ctr++;
                        output.append(element.data + String.format("%1$" + (25-element.data.length()) + "s  <-- TAIL\n", ctr));
                    } else if (ctr != 0) {
                        ctr++;
                        output.append(element.data + String.format("%1$" + (25-element.data.length()) + "s\n", ctr));
                    } else {
                        ctr++;
                        output.append(element.data + String.format("%1$" + (25-element.data.length()) + "s  <-- HEAD\n", ctr));
                    }
                    element = element.next;
                } while (element != null);
                output.append("-----------------------------------\n");
            }
            break;
        
        default: 
            // output with no annotations
            if (this.length == 0) {
                return "empty list.";
            } else {
                while (element != null) {
                    output.append(element.data + "\n");
                    element = element.next;
                }
            }
            break;
        }



        return output.toString();
    }

    public int getLength() {
        // returns current length of linked list
        return this.length;
    }

    class Element {
        // subclass to implement individual linked-list elements
        public Element next;
        public String data;
    
        // element constructor
        public Element(String data) {
            this.next = null;
            this.data = data;
        }
    }
}