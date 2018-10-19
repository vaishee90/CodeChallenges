
public class DavisStaircase {
    static long stepPerms(int n) {
        long[] mem = new long[n+1];
        if(mem[n] != 0)
            return mem[n];
        if(n <= 1){
            return 1;
        }  
        else if(n==2){
            return 2;
        }
        else{
//            if(mem[n] == 0)
//                mem[n] = stepPerms(n-3) + stepPerms(n-2) + stepPerms(n-1);
        	
        	mem[0] = 1;
        	mem[1] = 1;
        	mem[2] = 2;
        	for(int i=3;i<=n;i++)
        		mem[i] = mem[i-3] + mem[i-2] + mem[i-1];
        	
            return mem[n];
        }   
    }
    
    public static void main(String[] args) {
		System.out.println(stepPerms(135));
		System.out.println(stepPerms(36));
	}
}
