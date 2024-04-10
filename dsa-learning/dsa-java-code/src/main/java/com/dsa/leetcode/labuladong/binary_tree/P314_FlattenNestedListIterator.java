package com.dsa.leetcode.labuladong.binary_tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class P314_FlattenNestedListIterator {

    static class NestedIterator implements Iterator<Integer> {

        private LinkedList<NestedInteger> list;

        public NestedIterator(List<NestedInteger> nestedList) {
            list = new LinkedList<>(nestedList);
        }

        @Override
        public Integer next() {
            return list.removeFirst().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!list.isEmpty() && !list.getFirst().isInteger()) {
                List<NestedInteger> nestedIntegerList = list.removeFirst().getList();
                for (int i = nestedIntegerList.size() - 1; i >= 0; i--) {
                    list.addFirst(nestedIntegerList.get(i));
                }
            }
            return !list.isEmpty();
        }
    }


    public interface NestedInteger {
        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }
}
