package com.capcun.womenentrepreneur;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FeedGeneration {


    public static Map<String, List<String>> hashtagMap = new HashMap<>();

    FeedGeneration() {
        hashtagMap.put("Technology", Arrays.asList(
                "#Innovation",
                "#TechTrends",
                "#FutureTech",
                "#Gadgets",
                "#TechNews",
                "#AI",
                "#VR",
                "#Robotics",
                "#CyberSecurity",
                "#DataScience",
                "#CloudComputing",
                "#IoT",
                "#Software",
                "#Blockchain",
                "#TechCommunity",
                "#TechStartups",
                "#Programming",
                "#Coding",
                "#MachineLearning",
                "#TechEvents",
                "#DigitalTransformation",
                "#TechLife",
                "#SmartTechnology",
                "#InformationTechnology",
                "#TechSolutions"
        ));

        // Add entries for Retail and E-commerce sector
        hashtagMap.put("Retail and E-commerce", Arrays.asList(
                "#OnlineShopping",
                "#RetailTherapy",
                "#ShopLocal",
                "#Ecommerce",
                "#Retail",
                "#FashionRetail",
                "#CustomerExperience",
                "#RetailTrends",
                "#DigitalRetail",
                "#RetailInnovation",
                "#RetailDesign",
                "#RetailMarketing",
                "#EcommerceBusiness",
                "#RetailLife",
                "#RetailStore",
                "#RetailWorld",
                "#RetailStrategy",
                "#RetailTech",
                "#Retailers",
                "#ShopSmall",
                "#RetailSales",
                "#EcommerceTips",
                "#RetailGoals",
                "#RetailManagement",
                "#RetailSuccess"
        ));

        // Add entries for Healthcare and Wellness sector
        hashtagMap.put("Healthcare and Wellness", Arrays.asList(
                "#Healthcare",
                "#Wellness",
                "#MentalHealth",
                "#Fitness",
                "#HealthyLiving",
                "#HealthTips",
                "#Medical",
                "#HealthTech",
                "#HealthAndWellness",
                "#PublicHealth",
                "#HealthcareProfessionals",
                "#HealthcareInnovation",
                "#WellnessJourney",
                "#HealthcareIndustry",
                "#HealthcareServices",
                "#WellnessTips",
                "#HealthcareManagement",
                "#HealthcareTechnology",
                "#WellnessLifestyle",
                "#HealthcareSolutions",
                "#WellnessCoach",
                "#HealthcareReform",
                "#WellnessBlogger",
                "#HealthcareProviders",
                "#WellnessRetreat"
        ));

        hashtagMap.put("Professional Services", Arrays.asList(
                "#ProfessionalDevelopment",
                "#BusinessServices",
                "#Consulting",
                "#LegalServices",
                "#FinancialServices",
                "#ProfessionalGrowth",
                "#ServiceIndustry",
                "#ProfessionalNetworking",
                "#BusinessConsulting",
                "#LegalAdvice",
                "#FinancialPlanning",
                "#ProfessionalExcellence",
                "#ServiceDesign",
                "#BusinessStrategy",
                "#LegalTech",
                "#FinancialFreedom",
                "#ProfessionalSkills",
                "#ServiceQuality",
                "#BusinessIntelligence",
                "#LegalExpertise",
                "#FinancialGoals",
                "#ProfessionalLife",
                "#ServiceInnovation",
                "#BusinessGrowth",
                "#LegalIndustry"
        ));

        // Add entries for Education and E-learning sector
        hashtagMap.put("Education and E-learning", Arrays.asList(
                "#Education",
                "#Elearning",
                "#OnlineEducation",
                "#Learning",
                "#EdTech",
                "#StudentLife",
                "#DistanceLearning",
                "#EducationalTechnology",
                "#LearningAndDevelopment",
                "#HigherEducation",
                "#EducationReform",
                "#VirtualLearning",
                "#EducationForAll",
                "#LearningExperience",
                "#EducationSystem",
                "#OnlineCourses",
                "#EducationalResources",
                "#LearningPlatform",
                "#EducationSector",
                "#LearningTools",
                "#EducationLeadership",
                "#OnlineLearning",
                "#EducationalContent",
                "#LearningCommunity",
                "#EducationInnovation"
        ));

        // Add entries for Hospitality and Tourism sector
        hashtagMap.put("Hospitality and Tourism", Arrays.asList(
                "#Travel",
                "#Hospitality",
                "#Tourism",
                "#HotelLife",
                "#TravelIndustry",
                "#HospitalityIndustry",
                "#TouristAttraction",
                "#HospitalityManagement",
                "#TravelExperience",
                "#TourismTrends",
                "#HotelManagement",
                "#TravelAndLeisure",
                "#HospitalityLife",
                "#TourismMarketing",
                "#Hotelier",
                "#TravelTips",
                "#HospitalityServices",
                "#TourismDevelopment",
                "#HotelDesign",
                "#TravelBlogger",
                "#HospitalityBusiness",
                "#TourismSector",
                "#HotelBooking",
                "#TravelTech",
                "#HospitalityAndTourism"
        ));

        // Add entries for Finance and Fintech sector
        hashtagMap.put("Finance and Fintech", Arrays.asList(
                "#Finance",
                "#Fintech",
                "#FinancialServices",
                "#Investing",
                "#Banking",
                "#FinancialTechnology",
                "#WealthManagement",
                "#FinancialPlanning",
                "#FintechStartup",
                "#PersonalFinance",
                "#FinancialMarkets",
                "#FintechInnovation",
                "#FinancialEducation",
                "#BankTech",
                "#InvestmentBanking",
                "#FinancialAdvice",
                "#FintechNews",
                "#FinancialLiteracy",
                "#BankingIndustry",
                "#InvestmentStrategy",
                "#FinancialAnalysis",
                "#FintechRevolution",
                "#FinancialGrowth",
                "#BankingSolutions",
                "#FinancialWellness"
        ));

// Add entries for Manufacturing and Production sector
        hashtagMap.put("Manufacturing and Production", Arrays.asList(
                "#Manufacturing",
                "#Production",
                "#Industrial",
                "#ManufacturingIndustry",
                "#Factory",
                "#ProductionLine",
                "#ManufacturingTechnology",
                "#IndustrialDesign",
                "#ProductDevelopment",
                "#ManufacturingProcess",
                "#IndustrialEngineering",
                "#ProductionManagement",
                "#ManufacturingExcellence",
                "#IndustrialAutomation",
                "#ProductDesign",
                "#ManufacturingEngineering",
                "#IndustrialRevolution",
                "#ProductionPlanning",
                "#ManufacturingSolutions",
                "#IndustrialEquipment",
                "#ProductQuality",
                "#ManufacturingInnovation",
                "#IndustrialSector",
                "#ProductionEfficiency",
                "#ManufacturingTrends"
        ));

        // Add entries for Real Estate and Construction sector
        hashtagMap.put("Real Estate and Construction", Arrays.asList(
                "#RealEstate",
                "#Construction",
                "#Property",
                "#RealEstateAgent",
                "#HomeBuilding",
                "#RealEstateInvesting",
                "#ConstructionWork",
                "#PropertyManagement",
                "#RealEstateMarket",
                "#BuildingDesign",
                "#RealEstateDevelopment",
                "#ConstructionIndustry",
                "#PropertyInvestment",
                "#RealEstateLife",
                "#BuildingConstruction",
                "#RealEstateSales",
                "#ConstructionSite",
                "#PropertySearch",
                "#RealEstateTips",
                "#BuildingProjects",
                "#RealEstateBroker",
                "#ConstructionManagement",
                "#PropertyListing",
                "#RealEstatePhotography",
                "#BuildingMaterials"
        ));

// Add entries for Social Impact and Nonprofits sector
        hashtagMap.put("Social Impact and Nonprofits", Arrays.asList(
                "#SocialImpact",
                "#Nonprofit",
                "#Charity",
                "#SocialGood",
                "#Community",
                "#Philanthropy",
                "#MakeADifference",
                "#SocialChange",
                "#Changemakers",
                "#GiveBack",
                "#Education",
                "#NGO",
                "#SocialEnterprise",
                "#SocialResponsibility",
                "#Covid",
                "#Impact",
                "#ZeroHunger",
                "#SDGs",
                "#Love",
                "#Volunteer",
                "#UnitedNations",
                "#Donate",
                "#SocialEntrepreneur",
                "#Philanthropy",
                "#Change"
        ));

// Add entries for Art and Creative Industries sector
        hashtagMap.put("Art and Creative Industries", Arrays.asList(
                "#Art",
                "#Creativity",
                "#Design",
                "#Artist",
                "#CreativeIndustry",
                "#Artwork",
                "#CreativeDesign",
                "#ArtistsOnInstagram",
                "#DesignInspiration",
                "#Artistic",
                "#CreativeCommunity",
                "#ArtGallery",
                "#DesignThinking",
                "#ArtLife",
                "#CreativeProcess",
                "#ArtOfTheDay",
                "#DesignLife",
                "#ArtisticExpression",
                "#CreativeMinds",
                "#ArtExhibition",
                "#DesignStudio",
                "#ArtLovers",
                "#CreativeArts",
                "#ArtCollective",
                "#DesignArt"
        ));

// Add entries for Food and Beverage sector
        hashtagMap.put("Food and Beverage", Arrays.asList(
                "#Foodie",
                "#Beverage",
                "#FoodLover",
                "#Drink",
                "#FoodPhotography",
                "#BeverageIndustry",
                "#FoodBlogger",
                "#DrinkLocal",
                "#FoodAndDrink",
                "#BeverageBrand",
                "#FoodStyling",
                "#DrinkUp",
                "#FoodIndustry",
                "#BeverageCompany",
                "#FoodTrends",
                "#Drinkstagram",
                "#FoodBusiness",
                "#BeverageDevelopment",
                "#FoodInnovation",
                "#DrinkSpecials",
                "#FoodCulture",
                "#BeverageMenu",
                "#FoodProducts",
                "#DrinkHealthy",
                "#FoodService"
        ));
    }

    public static String findSectorByHashtag(String hashtag) {
        for (Map.Entry<String, List<String>> entry : hashtagMap.entrySet()) {
            List<String> hashtags = entry.getValue();
            if (hashtags.contains(hashtag)) {
                return entry.getKey();
            }
        }
        return "Sector not found for hashtag: " + hashtag;
    }

}