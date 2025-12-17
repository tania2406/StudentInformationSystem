# Installation Guide

## 1. Prerequisites

- Java Development Kit (JDK) 8 or above  
- Terminal/Command Prompt or any Java IDE (IntelliJ IDEA, Eclipse, VS Code)

Check your Java version:
  java -version

You should see a valid Java version printed.

---

## 2. Getting the Project

### Option A: Clone from GitHub

git clone https://github.com/<your-username>/<your-repo-name>.git
cd <your-repo-name>

### Option B: Download ZIP

1. Go to the GitHub repository page.  
2. Click **Code** → **Download ZIP**.  
3. Extract the ZIP and open the folder in your IDE or terminal.

---

## 3. Complie and Run(Command Line)

1. Navigate to the `src` directory:
   cd src

2. Compile the Java files:
   javac Student.java StudentManager.java ValidationUtils.java StudentInformationSystem.java
   
3. Run the application:
   java StudentInformationSystem
   
---


---

## 4. Running from an IDE

1. Open your IDE.  
2. **Import/Open Project** and select the repository root folder.  
3. Mark `src` as the Source Root if your IDE requires it.  
4. Locate `StudentInformationSystem.java` in the `src` folder.  
5. Run `StudentInformationSystem.main()` (usually right-click → **Run**).

---

## 5. Troubleshooting

- **`javac` or `java` not recognized**  
- Ensure the JDK `bin` directory is added to your system PATH.

- **Class not found when running**  
- Confirm you are in the `src` directory when running `java StudentInformationSystem`.  
- Ensure compilation succeeded and `.class` files exist.

- **Compilation errors**  
- Check that filenames and class names match exactly:
 - `Student.java`
 - `StudentManager.java`
 - `ValidationUtils.java`
 - `StudentInformationSystem.java`  
- Ensure you are using JDK 8 or later.
