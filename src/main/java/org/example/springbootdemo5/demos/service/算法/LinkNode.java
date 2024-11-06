package org.example.springbootdemo5.demos.service.算法;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LinkNode {


    private Node first;

    @Builder
    public static class Node{
        private Node next;
        private Integer value;
    }

    //尾插法
    public void add(Node newNode){
        if(first==null){
            first = newNode;
        }
        Node node = first;
        while (node!=null){
            node = node.next;
        }
        node = newNode;
    }
    // 遍历
    public void select(){
        Node node= first;
        while (node!=null){
            log.info("value:{}",node.value);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkNode linkNode = new LinkNode();
        linkNode.add(Node.builder().value(0).build());
        linkNode.select();

    }

    public void reverseNode(){

    }


}
