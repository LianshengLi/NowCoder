package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class ListProblems {
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    /**
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(listNode.val);
        while (listNode.next != null){
            list.add(listNode.next.val);
            listNode = listNode.next;
        }
        Collections.reverse(list);
        return list;
    }
    /**
     * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
     */
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode fast=pHead;
        ListNode low=pHead;
        if(fast==null||fast.next==null)
            return null;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            low=low.next;
            if(fast==low)
                break;
        }
        low=pHead;
        while(fast!=low){
            fast=fast.next;
            low=low.next;
        }
        return low;
    }
    /**
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
     * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     */

    public ListNode deleteDuplication(ListNode pHead) {
        //递归方法
        /*if (pHead == null || pHead.next == null) { // 只有0个或1个结点，则返回
            return pHead;
        }
        if (pHead.val == pHead.next.val) { // 当前结点是重复结点
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val) {
                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                pNode = pNode.next;
            }
            return deleteDuplication(pNode); // 从第一个与当前结点不同的结点开始递归
        } else { // 当前结点不是重复结点
            pHead.next = deleteDuplication(pHead.next); // 保留当前结点，从下一个结点开始递归
            return pHead;
        }*/
        //非递归方法
        if (pHead==null || pHead.next==null){return pHead;}
        //初始化一个辅助头结点，以防第一个和第二个节点就重复
        ListNode Head = new ListNode(0);
        //起始设为pHead
        Head.next = pHead;
        //pre 和 head为两个移动的指针 pre永远指向不重复的节点，last遍历所有节点
        ListNode pre  = Head;
        ListNode last = Head.next;
        while (last!=null){
            if(last.next!=null && last.val == last.next.val){
                // last循环直到最后一个重复的节点
                while (last.next!=null && last.val == last.next.val){
                    last = last.next;
                }
                //pre跳过中间重复的节点
                pre.next = last.next;
                last = last.next;
            }else{
                pre = pre.next;
                last = last.next;
            }
        }
        //不return pHead的原因是pHead可能是重复的
        return Head.next;
    }

}
