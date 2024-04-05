package com.capcun.womenentrepreneur;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SkillFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SkillFrag extends Fragment {

    RecyclerView newgroupsrecycler;
    LinearLayout choose;
    String datetime;

    private SkillAdapter newgrousadapter;
    LinearLayoutManager layoutManager;

    private ViewPager2 viewPager;
    private SliderAdapter sliderAdapter;
    private List<String> imageUrlList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SkillFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SkillFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static SkillFrag newInstance(String param1, String param2) {
        SkillFrag fragment = new SkillFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_skill, container, false);

        View view = inflater.inflate(R.layout.fragment_skill, container, false);

        newGroups(view);
        PopularNow(view);
        slider(view);


        TextView takeassessment = view.findViewById(R.id.takeassessment);
        takeassessment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),Assessment.class);
                startActivity(intent);
            }
        });


        ImageView cart = view.findViewById(R.id.cart);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),Addcources.class);
                startActivity(intent);
            }
        });


        return view;

    }

    private void slider(View view) {
        viewPager = view.findViewById(R.id.viewPager);
        imageUrlList = new ArrayList<>();
        imageUrlList.add("android.resource://" + requireActivity().getPackageName() + "/" + R.drawable.course2); // Add your image URLs here
        imageUrlList.add("android.resource://" + requireActivity().getPackageName() + "/" + R.drawable.course4); // Add your image URLs here

        imageUrlList.add("android.resource://" + requireActivity().getPackageName() + "/" + R.drawable.course4); // Add your image URLs here

        imageUrlList.add("URL_2");
        // Add more URLs as needed

        sliderAdapter = new SliderAdapter(getContext(), imageUrlList);
        viewPager.setAdapter(sliderAdapter);

        // Optionally, set orientation and other settings for the ViewPager2
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(3);
    }

    public void newGroups(View view)
    {
        List<SkillAssessmentModel> data_list; // Assuming this is already initialized

// Inside your onCreateView or onViewCreated method in your fragment
//        newgroupsrecycler = view.findViewById(R.id.newgroupsrecycler2);
//        layoutManager = new LinearLayoutManager(requireContext()); // Use requireContext() to get the context
//
//        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
//        newgroupsrecycler.setLayoutManager(layoutManager);


        newgroupsrecycler = view.findViewById(R.id.newgroupsrecycler2);
        newgroupsrecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        newgroupsrecycler.setLayoutManager(layoutManager);

// Assuming you have an adapter and set it to the RecyclerView somewhere below
// RecyclerView.Adapter<YourAdapterType> adapter = new YourAdapterType(data_list);
// newgroupsrecycler.setAdapter(adapter);


        data_list = new ArrayList<>();

//        data_list.add(new SkillAssessmentModel());
//        data_list.add(new SkillAssessmentModel());
//
//        data_list.add(new SkillAssessmentModel());
//        data_list.add(new SkillAssessmentModel());
//        data_list.add(new SkillAssessmentModel());
//
//        data_list.add(new SkillAssessmentModel());

        SkillAssessmentModel course1 = new SkillAssessmentModel("Introduction to Python Programming", "Learn the basics of Python programming language, including variables, loops, and functions.", "$29.99", 30+"");
        SkillAssessmentModel course2 = new SkillAssessmentModel("Web Development Fundamentals", "Explore the essentials of web development, including HTML, CSS, and JavaScript.", "$39.99", 25+"");
        SkillAssessmentModel course3 = new SkillAssessmentModel("Data Science for Beginners", "Get started with data science by learning about data analysis, visualization, and basic machine learning concepts.", "$49.99", 28+"");
        SkillAssessmentModel course4 = new SkillAssessmentModel("Java Programming Masterclass", "Dive deep into Java programming with hands-on projects and advanced concepts like multithreading and networking.", "$59.99", 32+"");
        SkillAssessmentModel course5 = new SkillAssessmentModel("Introduction to Artificial Intelligence", "Understand the fundamentals of AI, including machine learning, neural networks, and natural language processing.", "$69.99", 20+"");
        SkillAssessmentModel course6 = new SkillAssessmentModel("Graphic Design Essentials", "Learn the principles of graphic design, including typography, color theory, and layout design.", "$49.99", 15+"");
        SkillAssessmentModel course7 = new SkillAssessmentModel("Mobile App Development with React Native", "Build cross-platform mobile apps using React Native, covering UI design, state management, and deployment.", "$79.99", 10+"");
        SkillAssessmentModel course8 = new SkillAssessmentModel("Introduction to Blockchain Technology", "Explore the basics of blockchain, including cryptocurrency, smart contracts, and decentralized applications.", "$59.99", 5+"");
        SkillAssessmentModel course9 = new SkillAssessmentModel("Digital Marketing Fundamentals", "Discover the essentials of digital marketing, including SEO, social media marketing, and email campaigns.", "$49.99", 18+"");


        data_list.add(course1);
        data_list.add(course2);
        data_list.add(course3);
        data_list.add(course4);
        data_list.add(course5);
        data_list.add(course6);
        data_list.add(course7);
        data_list.add(course8);
        data_list.add(course9);



        newgrousadapter = new SkillAdapter(data_list, getContext());
        newgroupsrecycler.setAdapter(newgrousadapter);




    }

    public void PopularNow(View view)
    {
        List<SkillAssessmentModel> data_list;
        RecyclerView newgroupsrecycler = view.findViewById(R.id.popularnow);
        layoutManager = new LinearLayoutManager(getContext());

        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        newgroupsrecycler.setLayoutManager(layoutManager);


        data_list = new ArrayList<>();
        SkillAssessmentModel course10 = new SkillAssessmentModel("Cybersecurity Basics", "Learn about cybersecurity principles, threats, and defenses to protect against cyber attacks.", "$69.99", 22+"");
        SkillAssessmentModel course11 = new SkillAssessmentModel("Photography for Beginners", "Master the fundamentals of photography, including camera settings, composition techniques, and editing.", "$39.99", 12+"");
        SkillAssessmentModel course12 = new SkillAssessmentModel("UX/UI Design Essentials", "Dive into user experience and user interface design principles, wireframing, and prototyping.", "$59.99", 8+"");
        SkillAssessmentModel course13 = new SkillAssessmentModel("Project Management Fundamentals", "Learn project management methodologies, tools, and techniques for successful project execution.", "$49.99", 15+"");
        SkillAssessmentModel course14 = new SkillAssessmentModel("Introduction to Cloud Computing", "Explore cloud computing concepts, services, and deployment models, including AWS and Azure.", "$69.99", 25+"");
        SkillAssessmentModel course15 = new SkillAssessmentModel("Game Development with Unity", "Create your own games using Unity game engine, covering game design, scripting, and optimization.", "$79.99", 30+"");
        SkillAssessmentModel course16 = new SkillAssessmentModel("Advanced Excel Techniques", "Master advanced Excel functions, data analysis, and automation techniques for business purposes.", "$59.99", 13+"");
        SkillAssessmentModel course17 = new SkillAssessmentModel("Artificial Intelligence Ethics", "Delve into the ethical considerations surrounding artificial intelligence, including bias, privacy, and accountability.", "$49.99", 17+"");
        SkillAssessmentModel course18 = new SkillAssessmentModel("Music Production Basics", "Learn the basics of music production, including digital audio workstations (DAWs), mixing, and mastering.", "$39.99", 7+"");
        SkillAssessmentModel course19 = new SkillAssessmentModel("English Language Mastery", "Improve your English language skills, including grammar, vocabulary, and pronunciation.", "$29.99", 23+"");
        SkillAssessmentModel course20 = new SkillAssessmentModel("Financial Literacy for Beginners", "Gain fundamental knowledge of personal finance, budgeting, investing, and retirement planning.", "$49.99", 19+"");
        data_list.add(course10);
        data_list.add(course11);
        data_list.add(course12);
        data_list.add(course13);
        data_list.add(course14);
        data_list.add(course15);
        data_list.add(course16);
        data_list.add(course17);
        data_list.add(course18);
        data_list.add(course19);
        data_list.add(course20);

//        data_list.add(new Meetups());
//        data_list.add(new Meetups());
//
//        data_list.add(new Meetups());
//        data_list.add(new Meetups());
//        data_list.add(new Meetups());
//
//        data_list.add(new Meetups());




        SkillAdapter newgrousadapter = new SkillAdapter(data_list, getContext());
        newgroupsrecycler.setAdapter(newgrousadapter);




    }



}