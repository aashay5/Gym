package com.example.gym;

import java.util.ArrayList;

public class Utils {
    private static ArrayList<Training> trainings;
    private static ArrayList<Plan> plans;

    public static void initTrainings() {
        if (null == trainings) {
            trainings = new ArrayList<>();
        }
        Training pushUp = new Training(1, "Push-ups", "It has many modifications so beginners can start with easier versions and work up to the standard push-up, while you can find a challenging variation if you are advanced. You can do the push-up as part of a bodyweight exercise session, a circuit training workout, or a strength workout.", "The push-up may just be the perfect exercise that builds both upper-body and core strength. Done properly, it is a compound exercise that uses muscles in the chest, shoulders, triceps, back, abs, and even the legs.", "https://images.pexels.com/photos/3775164/pexels-photo-3775164.jpeg");
        trainings.add(pushUp);
        Training squat = new Training(2, "Squats", "Many of these muscles help power you through daily tasks such as walking, climbing stairs, bending, or carrying heavy loads. They also help you perform athletic-related activities. " +
                "Adding squats to your workouts can help boost your exercise performance, decrease your risk of injury, and keep you moving more easily throughout the day. But these are just a few of the benefits.", "The squat is a dynamic strength training exercise that requires several muscles in your upper and lower body to work together simultaneously.", "https://images.pexels.com/photos/371049/pexels-photo-371049.jpeg");
        trainings.add(squat);
        Training legPress = new Training(3, "Leg presses", "The leg press can be used to evaluate an athlete's overall lower body strength (from knee joint to hip). It can help to build squat strength. If performed correctly, the inclined leg press can help develop knees to manage heavier free weights, on the other hand, it has the potential to inflict grave injury: the knees could bend the wrong way if they are locked during the exercise.", "The leg press is a compound weight training exercise in which the individual pushes a weight or resistance away from them using their legs.", "https://barbend.com/wp-content/uploads/2019/04/Leg-Press-Guide.jpg");
        trainings.add(legPress);
        Training plank = new Training(4, "Planks", "The most common plank is the forearm plank which is held in a push-up-like position, with the body's weight borne on forearms, elbows, and toes. Many variations exist such as the side plank and the reverse plank. The plank is commonly practiced in Pilates and yoga, and by those training for boxing and other sports.\n" +
                "\n" +
                "The \"extended plank\" adds substantial difficulty to the standard plank exercise. To perform the extended plank, a person begins in the push-up position and then extends the arms or hands as far forward as possible.", "The plank (also called a front hold, hover, or abdominal bridge) is an isometric core strength exercise that involves maintaining a position similar to a push-up for the maximum possible time.", "https://images.livemint.com/img/2021/01/25/1140x641/iStock-628092382_1611576531363_1611576553196.jpg");
        trainings.add(plank);
        Training curls = new Training(5, "Curls", "There are several variations of this exercise, including those using dumbbells, kettlebells, barbells, resistance bands, or cable machines. Start with the standing alternating dumbbell biceps curl, which you can do anywhere. Curls are a typical exercise used in upper-body strength training routines.\n" +
                "\n", "The biceps curl is a highly recognizable weight-training exercise that works the muscles of the upper arm, and to a lesser extent, those of the lower arm", "https://oldschoollabs.com/wp-content/uploads/2019/06/15-2.jpg");
        trainings.add(curls);
        Training burpee = new Training(6, "Burpees", "Move into a squat position with your hands on the ground.\n" +
                "Kick your feet back into an extended plank position, while keeping your arms extended.\n" +
                "Immediately return your feet into squat position.\n" +
                "Stand up from the squat position.", "The burpee, a squat thrust with an additional stand between reps, is a full body exercise used in strength training. The movement itself is primarily an anaerobic exercise, but when done in succession over a longer period can be utilized in as an aerobic exercise.", "https://keepfitkingdom.com/wp-content/uploads/2020/01/Top-5-Benefits-of-Burpees-Keep-Fit-Kingdom-842x472-1280x720.jpg");
        trainings.add(burpee);
        Training sitUp = new Training(7, "Sit-ups", "It begins with lying with the back on the floor, typically with the arms across the chest or hands behind the head and the knees and toes bent in an attempt to reduce stress on the back muscles and spine, and then elevating both the upper and lower vertebrae from the floor until everything superior to the buttocks is not touching the ground. Some argue that situps can be dangerous due to high compressive lumbar load and may be replaced with the crunch in exercise programs.", "The sit-up (or curl-up) is an abdominal endurance training exercise to strengthen, tighten and tone the abdominal muscles. It is similar to a crunch (crunches target the rectus abdominis and also work the biceps and external and internal obliques), but sit-ups have a fuller range of motion and condition additional muscles.", "https://www.inposture.com/wp-content/uploads/2020/05/Sit-ups.jpg");
        trainings.add(sitUp);
        Training superman = new Training(8, "Superman", "What’s more, it complements other core exercises — such as leg raises and sit-ups — that mostly focus on the abdominal muscles in the front of your body.\n" +
                "\n" +
                "That said, you may wonder how to do it properly and safely to ensure you’re targeting the right muscles without hurting yourself.\n" +
                "\n" +
                "This article reviews the superman exercise, its benefits, how to do it, and some common mistakes.\n" +
                "\n" +
                "Though you may not become a superhero doing this exercise, you’ll definitely have a super strong core after adding it to your fitness routine.\n" +
                "\n", "The superman exercise is an effective and efficient exercise for people of all fitness levels. It targets your lower back muscles, glutes, hamstrings, and abs.", "https://fitstop24.com/media/superman-exercise_2.jpg.400x330_q95_crop-%2C_filters-detail.jpg");
        trainings.add(superman);
        Training cobra = new Training(9, "Cobras", "This pose has benefits that include strengthening your back muscles. However, it may need to be modified or avoided if you have certain back problems.", "The basic movement of the yoga Cobra pose is to arch the spine backward.", "https://www.rebalancept.com/wp-content/uploads/2017/04/AdobeStock_106193399-2.a9570610.jpg");
        trainings.add(cobra);
    }

    public static boolean removePlan(Plan plan){
        return plans.remove(plan);
    }
    public static ArrayList<Training> getTrainings() {
        return trainings;
    }

    public static boolean addPlan(Plan plan){
        if(null==plans){
            plans=new ArrayList<>();
        }

        return plans.add(plan);
    }

    public static ArrayList<Plan> getPlans() {
        return plans;
    }
}
