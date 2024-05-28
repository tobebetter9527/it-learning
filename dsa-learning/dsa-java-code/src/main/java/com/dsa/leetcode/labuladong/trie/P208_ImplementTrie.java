package com.dsa.leetcode.labuladong.trie;

import java.util.LinkedList;
import java.util.List;

public class P208_ImplementTrie {
    class Trie {
        // 直接封装 TrieSet
        TrieSet set = new TrieSet();

        // 插入一个元素
        public void insert(String word) {
            set.add(word);
        }

        // 判断元素是否在集合中
        public boolean search(String word) {
            return set.contains(word);
        }

        // 判断集合中是否有前缀为 prefix 的元素
        public boolean startsWith(String prefix) {
            return set.hasKeyWithPrefix(prefix);
        }

        class TrieMap<V> {
            /**
             * record range of charset
             */
            private int range;

            private int size;

            private TrieNode<V> root;

            public TrieMap() {
                this.range = 256;
                root = new TrieNode<>();
            }

            public TrieMap(int range) {
                this.range = range;
                root = new TrieNode<>();
            }

            private TrieNode<V> getNode(TrieNode<V> root, String key) {
                TrieNode<V> node = root;
                for (int i = 0, n = key.length(); i < n; i++) {
                    if (node == null) {
                        return null;
                    }
                    node = node.children[key.charAt(i)];
                }
                return node;
            }

            // 在 Map 中添加 key
            public void put(String key, V val) {
                if (!containsKey(key)) {
                    size++;
                }
                root = put(root, key, val, 0);
            }

            private TrieNode<V> put(TrieNode<V> node, String key, V val, int i) {
                if (node == null) {
                    node = new TrieNode<>();
                }
                if (i == key.length()) {
                    node.val = val;
                    return node;
                }
                char c = key.charAt(i);
                node.children[c] = put(node.children[c], key, val, i + 1);
                return node;
            }


            /***** 删 *****/

            // 删除键 key 以及对应的值
            public void remove(String key) {
                if (!containsKey(key)) {
                    return;
                }
                root = remove(root, key, 0);
                size--;
            }

            private TrieNode<V> remove(TrieNode<V> node, String key, int i) {
                if (node == null) {
                    return null;
                }
                if (i == key.length()) {
                    node.val = null;
                } else {
                    char c = key.charAt(i);
                    node.children[c] = remove(node.children[c], key, i + 1);
                }
                if (node.val != null) {
                    return node;
                }
                for (char j = 0; j < range; j++) {
                    if (node.children[j] != null) {
                        return node;
                    }
                }
                return null;
            }

            /***** 查 *****/

            // 搜索 key 对应的值，不存在则返回 null
            // get("the") -> 4
            // get("tha") -> null
            public V get(String key) {
                TrieNode<V> node = getNode(root, key);
                if (node != null && node.val != null) {
                    return node.val;
                }
                return null;
            }

            // 判断 key 是否存在在 Map 中
            // containsKey("tea") -> false
            // containsKey("team") -> true
            public boolean containsKey(String key) {
                return get(key) != null;
            }

            // 在 Map 的所有键中搜索 query 的最短前缀
            // shortestPrefixOf("themxyz") -> "the"
            public String shortestPrefixOf(String query) {
                TrieNode<V> node = root;
                for (int i = 0, n = query.length(); i < n; i++) {
                    if (node == null) {
                        return null;
                    }
                    if (node.val != null) {
                        return query.substring(0, i);
                    }
                    node = node.children[query.charAt(i)];
                }
                return node != null && node.val != null ? query : null;
            }

            // 在 Map 的所有键中搜索 query 的最长前缀
            // longestPrefixOf("themxyz") -> "them"
            public String longestPrefixOf(String query) {
                TrieNode<V> node = root;
                int maxLength = 0;
                for (int i = 0, n = query.length(); i < n; i++) {
                    if (node == null) {
                        break;
                    }
                    if (node.val != null) {
                        maxLength = i;
                    }
                    node = node.children[query.charAt(i)];
                }
                return node != null && node.val != null ? query : query.substring(0, maxLength);
            }

            // 搜索所有前缀为 prefix 的键
            // keysWithPrefix("th") -> ["that", "the", "them"]
            public List<String> keysWithPrefix(String prefix) {
                List<String> res = new LinkedList<>();
                TrieNode<V> node = getNode(root, prefix);
                if (node == null) {
                    return res;
                }
                traverse(node, new StringBuilder(prefix), res);
                return res;
            }

            private void traverse(TrieNode<V> node, StringBuilder path, List<String> res) {
                if (node == null) {
                    return;
                }
                if (node.val != null) {
                    res.add(path.toString());
                }
                for (char i = 0; i < range; i++) {
                    path.append(i);
                    traverse(node.children[i], path, res);
                    path.deleteCharAt(path.length() - 1);
                }
            }

            // 判断是和否存在前缀为 prefix 的键
            // hasKeyWithPrefix("tha") -> true
            // hasKeyWithPrefix("apple") -> false
            public boolean hasKeyWithPrefix(String prefix) {
                return getNode(root, prefix) != null;
            }

            // 通配符 . 匹配任意字符，搜索所有匹配的键
            // keysWithPattern("t.a.") -> ["team", "that"]
            public List<String> keysWithPattern(String pattern) {
                List<String> res = new LinkedList<>();
                traverse(root, new StringBuilder(), pattern, 0, res);
                return res;
            }

            private void traverse(TrieNode<V> node, StringBuilder path, String pattern, int idx, List<String> res) {
                if (node == null) {
                    return;
                }
                if (idx == pattern.length()) {
                    if (node.val != null) {
                        res.add(path.toString());
                    }
                    return;
                }
                char c = pattern.charAt(idx);
                if ('.' == c) {
                    for (char i = 0; i < range; i++) {
                        path.append(i);
                        traverse(node.children[i], path, pattern, idx + 1, res);
                        path.deleteCharAt(path.length() - 1);
                    }
                } else {
                    path.append(c);
                    traverse(node.children[c], path, pattern, idx + 1, res);
                    path.deleteCharAt(path.length() - 1);
                }
            }

            // 通配符 . 匹配任意字符，判断是否存在匹配的键
            // hasKeyWithPattern(".ip") -> true
            // hasKeyWithPattern(".i") -> false
            public boolean hasKeyWithPattern(String pattern) {
                return hasKeyWithPattern(root, pattern, 0);
            }

            private boolean hasKeyWithPattern(TrieNode<V> node, String pattern, int idx) {
                if (node == null) {
                    return false;
                }
                if (idx == pattern.length()) {
                    return node.val != null;
                }
                char c = pattern.charAt(idx);
                if ('.' == c) {
                    for (char i = 0; i < range; i++) {
                        if (hasKeyWithPattern(node.children[i], pattern, idx + 1)) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    return hasKeyWithPattern(node.children[c], pattern, idx + 1);
                }
            }

            // 返回 Map 中键值对的数量
            public int size() {
                return size;
            }

            private class TrieNode<V> {
                V val = null;
                TrieNode<V>[] children;

                public TrieNode() {
                    this.children = new TrieNode[range];
                }
            }
        }

        class TrieSet {
            // 底层用一个 TrieMap，键就是 TrieSet，值仅仅起到占位的作用
            // 值的类型可以随便设置，我参考 Java 标准库设置成 Object
            private final TrieMap<Object> map = new TrieMap<>();

            private final Object object = new Object();

            /***** 增 *****/

            // 在集合中添加元素 key
            public void add(String key) {
                map.put(key, object);
            }

            /***** 删 *****/

            // 从集合中删除元素 key
            public void remove(String key) {
                map.remove(key);
            }

            /***** 查 *****/

            // 判断元素 key 是否存在集合中
            public boolean contains(String key) {
                return map.containsKey(key);
            }

            // 在集合中寻找 query 的最短前缀
            public String shortestPrefixOf(String query) {
                return map.shortestPrefixOf(query);
            }

            // 在集合中寻找 query 的最长前缀
            public String longestPrefixOf(String query) {
                return map.longestPrefixOf(query);
            }

            // 在集合中搜索前缀为 prefix 的所有元素
            public List<String> keysWithPrefix(String prefix) {
                return map.keysWithPrefix(prefix);
            }

            // 判断集合中是否存在前缀为 prefix 的元素
            public boolean hasKeyWithPrefix(String prefix) {
                return map.hasKeyWithPrefix(prefix);
            }

            // 通配符 . 匹配任意字符，返回集合中匹配 pattern 的所有元素
            public List<String> keysWithPattern(String pattern) {
                return map.keysWithPattern(pattern);
            }

            // 通配符 . 匹配任意字符，判断集合中是否存在匹配 pattern 的元素
            public boolean hasKeyWithPattern(String pattern) {
                return map.hasKeyWithPattern(pattern);
            }

            // 返回集合中元素的个数
            public int size() {
                return map.size();
            }
        }
    }

}
