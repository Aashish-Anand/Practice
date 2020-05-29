package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C1359 {
    public static void main(String[] args) throws IOException {
        new C1359().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        while(t-- > 0) {
            String s[] = reader.readLine().split(" ");
            int h = Integer.parseInt(s[0]);
            int c = Integer.parseInt(s[1]);
            int temp = Integer.parseInt(s[2]);



            int x = (int)Math.ceil((temp - c)/(2*temp - h- c));
            System.out.println(x+(x-1));
        }
    }
}

    ld sg(ll p,ll q,ll n){
        return ((ld)p*(n+1)+q*n)/(2*n+1);
    }

    void solve(){
        cin>>p>>q>>h;
        if(p+q>=2*h)cout<<2<<el;
        else{
            z=(p-h)/(2*h-p-q);
            if(abs(sg(p,q,z)-h)>abs(sg(p,q,z+1)-h))cout<<2*z+3<<el;
            else cout<<2*z+1<<el;
        }
    }
