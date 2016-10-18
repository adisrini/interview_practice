package leetcode;

public class JumpGame {
    
    enum Position {
        GOOD, BAD, UNKNOWN;
    }
    
    public boolean canJump(int[] nums) {
        Position[] positions = new Position[nums.length];
        for(int i = 0; i < positions.length; i++) {
            positions[i] = Position.UNKNOWN;
        }
        positions[positions.length - 1] = Position.GOOD;
        int lastGoodPos = positions.length - 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            if(i + nums[i] >= lastGoodPos) {
                positions[i] = Position.GOOD;
                lastGoodPos = i;
            }
        }
        
        return positions[0].equals(Position.GOOD);
    }

    
}
