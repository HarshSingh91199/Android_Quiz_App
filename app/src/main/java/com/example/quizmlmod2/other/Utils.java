package com.example.quizmlmod2.other;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;

import com.example.quizmlmod2.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Utils {

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public static String formatDate(long time){
        SimpleDateFormat formatter = new SimpleDateFormat(Constants.DATE_FORMAT, Locale.getDefault());

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return formatter.format(calendar.getTime());
    }

    public static Map<String,Map<String,Boolean>> getRandomQuestions(){
        HashMap<String,Map<String,Boolean>> questions = new HashMap<>();

        HashMap<String,Boolean> answer1 = new HashMap<>();
        answer1.put("Mining of Association.",false);
        answer1.put("Mining of Clusters.",false);
        answer1.put("Mining of Correlations",true);
        answer1.put("None of the above.",false);
        questions.put("The analysis performed to uncover interesting statistical correlations between associated-attribute-value pairs is called?",answer1);

        HashMap<String,Boolean> answer2 = new HashMap<>();
        answer2.put("chartss",true);
        answer2.put("All of the above",false);
        answer2.put("graphs",false);
        answer2.put("maps",false);
        questions.put("Data can be visualized using",answer2);

        HashMap<String,Boolean> answer3 = new HashMap<>();
        answer3.put("Database Technology",false);
        answer3.put("Machine Learning",false);
        answer3.put("Information Science",false);
        answer3.put("All of the above",true);
        questions.put("Data Mining System Classification consists of?",answer3);

        HashMap<String,Boolean> answer4 = new HashMap<>();
        answer4.put("Mining Methodology and User Interaction Issues",false);
        answer4.put("Performance Issues",true);
        answer4.put("Diverse Data Types Issues",false);
        answer4.put("None Of the above",false);
        questions.put("\"Efficiency and scalability of data mining algorithms\" issues comes under?",answer4);

        HashMap<String,Boolean> answer5 = new HashMap<>();
        answer5.put("levelplot",false);
        answer5.put("featurePlot",true);
        answer5.put("plotsample",false);
        answer5.put("None of the above",false);
        questions.put("Which of the following function is a wrapper for different lattice plots to visualize the data?",answer5);

        HashMap<String,Boolean> answer6 = new HashMap<>();
        answer6.put("Sales and marketing",false);
        answer6.put("Healthcare",false);
        answer6.put("Politics",false);
        answer6.put("All of the above",true);
        questions.put("Common use cases for data visualization include",answer6);

        HashMap<String,Boolean> answer7 = new HashMap<>();
        answer7.put("Data Characterization",false);
        answer7.put("Data Discrimination",true);
        answer7.put("Data Set",false);
        answer7.put(" Data Sub Structure",false);
        questions.put("The mapping or classification of a class with some predefined group or class is known as?",answer7);

        HashMap<String,Boolean> answer8 = new HashMap<>();
        answer8.put("Ridge",true);
        answer8.put("LASSO",false);
        answer8.put("Both",false);
        answer8.put("None of these",false);
        questions.put("Which of the following algorithms do we use for Variable Selection ?",answer8);

        HashMap<String,Boolean> answer9 = new HashMap<>();
        answer9.put("to remove the noisy data",false);
        answer9.put("correct the inconsistencies in data",false);
        answer9.put("transformations to correct the wrong data.",false);
        answer9.put("All of the above",true);
        questions.put("What is the use of data cleaning?",answer9);

        HashMap<String,Boolean> answer10 = new HashMap<>();
        answer10.put("Outlier Analysis",true);
        answer10.put("Evolution Analysis",false);
        answer10.put("Prediction",false);
        answer10.put("Classification",false);
        questions.put("__________ may be defined as the data objects that do not comply with the general behavior or model of the data available.",answer10);

        HashMap<String,Boolean> answer11 = new HashMap<>();
        answer11.put("2",true);
        answer11.put("3",false);
        answer11.put("4",false);
        answer11.put("5",false);
        questions.put("To integrate heterogeneous databases, how many approaches are there in Data Warehousing?",answer11);

        HashMap<String,Boolean> answer12 = new HashMap<>();
        answer12.put("Higher ‘k’ means less regularization",true);
        answer12.put("Can’t Say",false);
        answer12.put("Higher ‘k’ means more regularization",false);
        answer12.put("No Relation between k and regularization ",false);
        questions.put("Suppose we are using dimensionality reduction as pre-processing technique, i.e, instead of using all the features, we reduce the data to k dimensions with PCA. And then use these PCA projections as our features. Which of the following statement is correct? ",answer12);

        HashMap<String,Boolean> answer13 = new HashMap<>();
        answer13.put("1 and 2",true);
        answer13.put("1 and 3",false);
        answer13.put("2 and 3",false);
        answer13.put("1 ,2 and 3",false);
        questions.put("PCA works better if there is? 1 A linear structure in the data 2 If the data lies on a curved surface and not on a flat surface 3 If variables are scaled in the same unit",answer13);

        HashMap<String,Boolean> answer14 = new HashMap<>();
        answer14.put("PCA will perform outstandingly",true);
        answer14.put("None of above",false);
        answer14.put("PCA will perform badly",false);
        answer14.put("Can’t Say",false);
        questions.put("What will happen when eigenvalues are roughly equal?",answer14);

        HashMap<String,Boolean> answer15 = new HashMap<>();
        answer15.put("Removing columns which have too many missing values",true);
        answer15.put("Removing columns which have high variance in data",false);
        answer15.put("Removing columns with dissimilar data trends",false);
        answer15.put("None of these",false);
        questions.put("Which of the following techniques would perform better for reducing dimensions of a data set?",answer15);

        return questions;
    }

    public static Map<String,Map<String,Boolean>> getRandomQuestions(Context context, String subject, int SIZE){
        Map<String,Map<String,Boolean>> questionsMap = new HashMap<>();
        Map<String, Map<String, Boolean>> originalQuestion;
        originalQuestion = getRandomQuestions();

        int originalSize =  originalQuestion.size();
        ArrayList<String> keyList = new ArrayList<String>(originalQuestion.keySet());

        while (questionsMap.size()<=SIZE){
            Random random = new Random();
            int randomNumber = random.nextInt(originalSize);
            String question = keyList.get(randomNumber);
            if (!questionsMap.containsKey(question)){
                questionsMap.put(question,originalQuestion.get(question));
            }
        }
        return questionsMap;
    }

}
