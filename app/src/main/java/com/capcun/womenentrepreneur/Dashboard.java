package com.capcun.womenentrepreneur;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.capcun.womenentrepreneur.fetchPosts.FetchPostModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Dashboard extends AppCompatActivity {


    private  ShortsFrag shortsFrag;
    private  PostFrag postFrag;

    private FundingFrag fundingFrag;


    private  SkillFrag skillFrag;
    private  EventFrag eventFrag;
    private Fragment activeFragment;
    RecyclerView recycler;


    LinearLayoutManager layoutManager;
    FetchPostAdpater fetchLeadAdpater;
    final String sharedPreferencesFileTitle = "sheeo";

    CardView profile,msg;
    List<DataLeadsNew> data_list = new ArrayList<>();


    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setTheme(R.style.StatusBarTheme);
        }
        setContentView(R.layout.activity_dashboard);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(android.R.color.white));
        }



        bottomNavigationView = findViewById(R.id.bottom_navigation);
        fragmentManager = getSupportFragmentManager();

        // Set the initial fragment
        shortsFrag = new ShortsFrag();
        postFrag = new PostFrag();
        eventFrag = new EventFrag();
        skillFrag = new SkillFrag();
        fundingFrag = new FundingFrag();

        // Set the initial active fragment
        activeFragment = postFrag;
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, activeFragment).commit();

        // Retrieve BottomNavigationView
        bottomNavigationView = findViewById(R.id.bottom_navigation);


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                Fragment selectedFragment;
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        selectedFragment = postFrag;
                        break;
                    case R.id.navigation_short:
                        selectedFragment = shortsFrag;
                        break;
                    case R.id.navigation_event:
                        selectedFragment = eventFrag;
                        break;
                    case R.id.navigation_skill:
                        selectedFragment = skillFrag;
                        break;
                    case R.id.navigation_funding:
                        selectedFragment = fundingFrag;
                        break;
                    default:
                        return false;
                }
                if (selectedFragment != activeFragment) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    activeFragment = selectedFragment;
                }
                return true;
            }
        });




        msg = findViewById(R.id.message_icon);
        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Dashboard.this,Messages.class);
                startActivity(in);
            }
        });
//        SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.swipe_layout);
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//
//                Intent intent = new Intent(Dashboard.this, Dashboard.class);
////                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent);
//
//                swipeRefreshLayout.setRefreshing(false);
//            }
//        });








//
//        // Entrepreneur Posts
//        data_list.add(0, new DataLeadsNew("Aanya Sharma","CEO","12h", "entrepreneur", "Green Revolution Co.", "Excited to announce a groundbreaking partnership with [Company Name] to revolutionize eco-friendly packaging solutions! Together, we'll be helping major retailers across the country adopt sustainable practices that minimize environmental impact. This is a huge win for conscious consumers and the planet! #sustainability #greenbusiness #ecopackaging"));
//
//        data_list.add(0, new DataLeadsNew("Priyanka Singh","Founder & Designer","1d", "entrepreneur", "Kimono Sutra", "Calling all fashionistas! Take a sneak peek behind the scenes of our stunning new Fall collection shoot! We can't wait to unveil these exquisite designs that blend traditional Indian craftsmanship with modern silhouettes at [Fashion Week Name] next month. Get ready to be inspired! #sustainablefashion #indianfashion #fallcollection [Short video snippet of the photoshoot featuring close-ups of the designs and the creative process]"));
//
//        data_list.add(0, new DataLeadsNew("Anika Desai","Business Analyst","2d", "entrepreneur", "FinTech Solutions", "Thrilled to be a part of the Women in Finance Forum this year! It's inspiring to connect with so many talented women making waves in the financial industry. Together, we're breaking barriers and paving the way for a more inclusive future. #womeninfinance #financialempowerment"));
//
//        data_list.add(0, new DataLeadsNew("Disha Rao","Architect","3d", "entrepreneur", "Green Habitat Design", "New project alert! Designing a sustainable housing complex that prioritizes energy efficiency and utilizes recycled materials. This project is a testament to the power of green building practices for a healthier planet and a more comfortable living experience. Stay tuned for progress updates!"));
//
//        data_list.add(0, new DataLeadsNew("Priya Bajaj","Web Developer","4d", "entrepreneur", "She-E-O App", "Building the future of women-led businesses, one line of code at a time! It's exciting to be part of a team that's creating a platform to empower and connect women entrepreneurs. #womenintech #SheEOapp"));
//
//// Student Posts
//        data_list.add(0, new DataLeadsNew("Saiba Malhotra","Marketing Manager","15h", "student", "Social Media Today", "Just launched our new social media marketing course specifically designed for women entrepreneurs! Learn the latest strategies and tactics to build a strong online presence and reach your target audience. Enroll now and take your business to the next level! [link to course]"));
//
//        data_list.add(0, new DataLeadsNew("Kiara Mehta","Content Creator","18h", "student", "The Sustainable Edit", "Eco-friendly living doesn't have to be complicated! Sharing my top tips for making sustainable swaps in your everyday routine - from choosing reusable grocery bags to opting for energy-efficient appliances. Join the eco-conscious movement and make a difference for our planet! #sustainableliving #gogreen"));
//
//// Investor Posts
//        data_list.add(0, new DataLeadsNew("Aisha Khan","Investment Banker","1d", "investor", "She Invests", "Investing in female-founded businesses is not just about financial returns - it's about empowering women and fostering innovation! We believe in the power of women entrepreneurs to drive positive change in the world. Learn more about our investment philosophy and join our mission! [Link to website]"));
//
//        data_list.add(0, new DataLeadsNew("Shivani Shah","Lawyer","2d", "investor", "Women's Legal Rights Project", "Fighting for equal pay rights is not just a fight for women - it's a fight for a fair and just society. Join us in advocating for equal pay for equal work! Donate today and help us make a difference. [Link to donation page]"));
//
//// Mentor Posts
//        data_list.add(0, new DataLeadsNew("Rani Singh","Founder & CEO","3d", "mentor", "SheCares", "Building a supportive community for women in healthcare to connect, share experiences, and learn from each other. Whether you're a doctor, nurse, or healthcare professional, SheCares is a space for you to thrive. Join us today! [Link to online community forum]"));
//
//        data_list.add(0, new DataLeadsNew("Anika Desai","Public Speaker & Motivational Coach","4d", "mentor", "Empowering Women to Reach Their Full Potential", "Empowering women to reach their full potential requires self-belief, resilience, and a willingness to step outside their comfort zone. Sharing tips and strategies for overcoming self-doubt, setting achievable goals, and achieving success on your terms. Join my upcoming workshop and unlock your inner power! [Link to registration for Anika's workshop]"));
//
//// Add more posts for each type as needed
//





        profile = findViewById(R.id.user_profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this,User_Profile.class);
                startActivity(intent);
            }
        });



}
}