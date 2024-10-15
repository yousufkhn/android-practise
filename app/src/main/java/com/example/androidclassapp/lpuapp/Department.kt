package com.example.androidclassapp.lpuapp

import com.example.androidclassapp.R

object DepartmentsData {
    val departments = listOf(
        Department(
            "Computer Science",
            "Department of Computer Science and Engineering",
            R.drawable.cs_logo,
            "The Computer Science Department at LPU offers cutting-edge courses in software engineering, data science, artificial intelligence, and cyber security. With state-of-the-art labs and industry partnerships, students gain hands-on experience in the latest technologies.",
            listOf(R.drawable.cs_img1,R.drawable.cs_img2,R.drawable.cs_img3),
            R.raw.cs_lottie
        ),
        Department(
            "Agriculture Department",
            "Department of Agriculture",
            R.drawable.agri_logo,
            "LPU's Agriculture Department provides comprehensive education in agricultural sciences, sustainable farming, agribusiness, and biotechnology. The department focuses on modern agricultural practices and innovations to address the growing needs of the sector.",
            listOf(R.drawable.cs_img1,R.drawable.cs_img2,R.drawable.cs_img3),
            R.raw.agri_lottie
        ),
        Department(
            "BioScience Department",
            "Department of BioScience and BioEngineering",
            R.drawable.bio_logo,
            "The BioScience Department offers a diverse range of programs in biotechnology, microbiology, and environmental sciences. It equips students with research skills and practical knowledge for careers in health, pharmaceuticals, and ecological conservation.",
            listOf(R.drawable.cs_img1,R.drawable.cs_img2,R.drawable.cs_img3),
            R.raw.bio_lottie
        ),
        Department(
            "Social Science", "Department of Liberal and Creative Arts",
            R.drawable.social_logo,
            "The Social Science Department at LPU focuses on understanding human behavior and societies through disciplines like psychology, sociology, and political science. The department encourages critical thinking and prepares students for careers in research, public service, and education.",
            listOf(R.drawable.cs_img1,R.drawable.cs_img2,R.drawable.cs_img3),
            R.raw.social_lottie
        ),
        Department(
            "Design Department",
            "Design-III (Multimedia and Design)",
            R.drawable.design_logo,
            "LPU's Design Department nurtures creativity and innovation through programs in fashion design, interior design, product design, and graphic design. Students learn to blend aesthetics with functionality, supported by modern studios and design labs.",
            listOf(R.drawable.cs_img1,R.drawable.cs_img2,R.drawable.cs_img3),
            R.raw.design_lottie
        ),
        Department(
            "Physiotherapy and Paramedical",
            "Department of Physiotherapy and Paramedical",
            R.drawable.para_logo,
            "The Physiotherapy and Paramedical Department offers rigorous programs aimed at producing skilled healthcare professionals. Courses cover physiotherapy techniques, medical lab technology, and emergency care, preparing students for critical roles in the healthcare industry.",
            listOf(R.drawable.cs_img1,R.drawable.cs_img2,R.drawable.cs_img3),
            R.raw.para_lottie
        ),
        Department(
            "Hotel Management",
            "Hotel Management and Tourism",
            R.drawable.hotel_logo,
            "LPU's Hotel Management Department offers specialized training in hospitality management, culinary arts, and tourism. With hands-on experience in luxury hotels and resorts, students are prepared to excel in the global hospitality industry.",
            listOf(R.drawable.cs_img1,R.drawable.cs_img2,R.drawable.cs_img3),
            R.raw.hotel_lottie
        ),
        Department(
            "Mechanical Engineering",
            " Department of Mechanical Engineering",
            R.drawable.mechanical_logo,
            "The Mechanical Engineering Department provides in-depth training in mechanics, thermodynamics, robotics, and manufacturing. With advanced labs and industry tie-ups, students gain practical skills essential for careers in engineering and technology.",
            listOf(R.drawable.cs_img1,R.drawable.cs_img2,R.drawable.cs_img3),
            R.raw.mech_lottie
        ),
        Department(
            "Architecture Department",
            " Department of Architecture and Design",
            R.drawable.arch_logo,
            "Very Nice Department",
            listOf(R.drawable.cs_img1,R.drawable.cs_img2,R.drawable.cs_img3),
            R.raw.arch_lottie
        )

    )
}

data class Department (
    val name:String,
    val fullName:String,
    val imageResId:Int,
    val description:String,
    val imagesResIds:List<Int>,
    val departmentLottieResId:Int
)