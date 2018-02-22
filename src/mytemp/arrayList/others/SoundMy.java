package mytemp.arrayList.others;
import acm.util.RandomGenerator;
import acm.util.SoundClip;
import com.shpp.cs.a.console.TextProgram;
import com.shpp.cs.a.lectures.lec10.StdAudio;

public class SoundMy extends TextProgram{

    public void run(){
        RandomGenerator random = new RandomGenerator();

        double []  ArrMy = new double[90000];

        for (int i = 0; i < ArrMy.length; i++){
            double cos =  Math.cos(i);
            ArrMy[i]= random.nextDouble(-cos, cos);
        }

         StdAudio.play(ArrMy);

    }
}
