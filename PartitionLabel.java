import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class PartitionLabel {
	
	// option 1
	public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] curOccurance = new int[26];
        int count = 0;
        Set<Character> diffWordsInWindow = new HashSet<>();
        for (char c : S.toCharArray()) {
            curOccurance[c - 'a']++;
        }
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            diffWordsInWindow.add(c);
            curOccurance[c - 'a']--;
            count++;
            if (curOccurance[c - 'a'] == 0) {
                diffWordsInWindow.remove(c);
            }
            if (diffWordsInWindow.size() == 0) {
                res.add(count);
                count = 0;
            }
        }
        return res;
    }
	
	public List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int[] map = new int[26];  // record the last index of the each char

        for (char c : S.toCharArray()) {
            lastIndexMap[c - 'a']++;
        }
        // record the end index of the current sub string
        int last = 0;
        int start = 0;
        for(int i = 0; i < S.length(); i++){
            last = Math.max(last, lastIndexMap[S.charAt(i)-'a']);
            if(last == i){
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }
	
    # Claim:
        # By repeatedly removing and then storing the substring S[:k]
        # s.t. 
        # 1. k > 0 and k is minimum.
        # 2. no character in S[:k] appears in S[k:]
        # We can obtain the optimal answer (i.e. largest number of partitions)

        # Proof:
        # Assume there exists an optimal partition (k1, k2, ..., kn).
        # We need 2 lemmas:
        # 1. For the optimal partition to S[k1:] -> (k2', k3', ..., kn')
        #    (k1, k2', ..., kn') is also an optimal partition to S[:]
        #    - By definition of partition, no letter in S[:k1] appears in S[k1:].
        #      Therefore, the answer to S[k1:] and S[:k1] are independent to each other,
        #      meaning that to optimize for S[:], we can optimize for S[k1:] and S[:k1]
        #      respectively, and combine the solutions.
        # 2. k1 satisfies the requirements for k in the claim.
        #    - k1 satisfies the second requirement in the claim, and k > 0 automatically by definition of
        #      partition. So if k1 is not the minimum value for partition, we can easily break the
        #      partition into (k, k1 - k, k2, ..., kn), contradiction.
        #
        # The original claim is conceptually equivalent to:
        # - Find the k that satisfies the claim, and then re-apply this operation to S[k:].
        #
        # Proof:
        # Lemma2 shows that such k must be in an optimal partition; lemma1 shows that re-applying
        # the operation and combining the partitions at the end yield an global optimal solution.
        # Q.E.D.
}