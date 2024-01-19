# author: tobebetter9527
# since: 2024/1/19 9:20
from typing import List


class Solution:
    def advantageCount(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n = len(nums1)

        idx2 = [i for i in range(n)]
        idx2.sort(key=lambda x: nums2[x])
        nums1.sort()

        ans = [0 for i in range(n)]
        left, right = 0, n - 1
        i = n - 1
        while i >= 0:
            tempIdx = idx2[i]
            if nums1[right] > nums2[tempIdx]:
                ans[tempIdx] = nums1[right]
                right -= 1
            else:
                ans[tempIdx] = nums1[left]
                left += 1
            i -= 1
        return ans


if __name__ == '__main__':
    nums1 = [2, 7, 11, 15]
    nums2 = [1, 10, 4, 11]
    solu = Solution()
    ans = solu.advantageCount(nums1, nums2)
    print(ans)
