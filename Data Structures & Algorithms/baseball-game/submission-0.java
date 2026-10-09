class Solution {
    public int calPoints(String[] operations) {
        int n = operations.length;
        int sum = 0;
        List<Integer> record = new ArrayList<>();
        for(int i=0;i<n;i++){
        String op=operations[i];
        if(op.equals("+")){
            int score=record.get(record.size()-1)+record.get(record.size()-2);
            record.add(score);
            sum+=score;
        }
        else if(op.equals("C")){
            int removed=record.remove(record.size()-1);
            sum-=removed;
        }
        else if(op.equals("D")){
            int score=2*record.get(record.size()-1);
            record.add(score);
            sum+=score;
        }
        else{
            int score = Integer.parseInt(op);
                record.add(score);
                sum += score;
        }
        }
        return sum;
    }
    }
