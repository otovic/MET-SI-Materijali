# Define the course structure
courses = {
    "SOFTVERSKO INŽENJERSTVO": {
        1: {
            1: {
                "CS101": "Uvod u programiranje",
                "CS102": "Osnove računarskih nauka",
            },
            2: {
                "CS103": "Algoritmi i strukture podataka",
                "CS104": "Diskretna matematika",
            },
        },
        2: {
            3: {
                "CS201": "Objektno orijentisano programiranje",
                "CS202": "Baze podataka",
            },
            4: {
                "CS230": "Distribuirani sistemi",
                "CS204": "Operativni sistemi",
            },
        },
    },
    "INFORMACIONE TEHNOLOGIJE": {
        1: {
            1: {
                "IT101": "Osnove informacionih tehnologija",
                "IT102": "Računarske mreže",
            },
            2: {
                "IT103": "Sigurnost informacionih sistema",
                "IT104": "Skladišta podataka",
            },
        },
        2: {
            3: {
                "IT201": "Napredne mreže",
                "IT202": "Cloud computing",
            },
            4: {
                "IT230": "Big Data",
                "IT204": "IoT tehnologije",
            },
        },
    }
}

def find_course_path(course_code):
    for smer, years in courses.items():
        for year, semesters in years.items():
            for semester, subjects in semesters.items():
                if course_code in subjects:
                    course_name = subjects[course_code]
                    return f"{smer} > Godina #{year} > Semestar #{semester} > {course_code} - {course_name}"
    return "Course code not found"

# Input
course_code = "CS230"
# Output
print(find_course_path(course_code))