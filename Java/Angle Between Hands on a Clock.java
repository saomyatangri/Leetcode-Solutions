class Solution {
    public double angleClock(int hour, int minutes) {
        double hrDiff = (double)minutes/12;
        //System.out.println("hrDiff: " + hrDiff);
        
        double hrInMins = (hour * 5) + hrDiff;
        //System.out.println("hrInMins: " + hrInMins);
        
        double tempDiff = hrInMins - minutes;
        double diff = tempDiff < 0 ? tempDiff *-1 : tempDiff;
        //System.out.println("diff: " + diff);
        
        double diff1 = (Math.abs(hrInMins - minutes))*6;
        double diff2 = 360 - diff1;
        return diff1 < diff2 ? diff1 : diff2;
    }
}
