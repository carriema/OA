public class ReorderLogs {
	public static void main(String[] args) {
		
	}
	
	public String[] reorderLogFiles(String[] logs) {
        if (logs.length <= 1) {
            return logs;
        }
        int fast = logs.length - 1;
        int slow = logs.length - 1;
        while (fast >= 0) {
            if (Character.isDigit(logs[fast].charAt(logs[fast].length() - 1))) {
                swap(logs, fast, slow);
                slow--;
                fast--;
            } else {
                fast--;
            }
        }
        Arrays.sort(logs, 0, slow + 1, new Comparator<String>(){// sort only the log contains letter
            public int compare(String s1, String s2){
                int i1 = s1.indexOf(' '), i2 = s2.indexOf(' ');
                String id1 = s1.substring(0,i1),id2 = s2.substring(0,i2);
                String word1 = s1.substring(i1), word2 = s2.substring(i2);      
                if(!word1.equals(word2)) return word1.compareTo(word2);//if words not the same, compare word1 word2
                else return id1.compareTo(id2);                      //if word is the same, then compare id1, id2
            }
        });
        return logs;
    }
    public void swap(String[] logs, int a, int b) {
        if (a == b) {
            return;
        }
        String temp = logs[a];
        logs[a] = logs[b];
        logs[b] = temp;
    }
    
    // best case is when all logs are digit, it cost O(N). Worst case is when all logs are letter, it cost O(NlogN). General time complexity is O(NlogN)
    // when doing the sorting part.
}