# Java Environment Setup Instructions

## JDK Version Used

```
openjdk version "21.0.12.1" 2026-08-18
OpenJDK Runtime Environment (build 21.0.12.1+1-1-24.04.4-Ubuntu)
OpenJDK 64-Bit Server VM (build 21.0.12.1+1-1-24.04.4-Ubuntu, mixed mode, sharing)
```

- **JDK:** OpenJDK 21 (LTS)
- **Compiler:** `javac 21.0.12.1`

---

## Setting Up the Project in IntelliJ IDEA

These steps work on **Windows, macOS, and Linux**.

---

### Step 1 — Install a JDK

Download and install **JDK 17 or later** from one of these sources:

| Distribution | Download link |
|---|---|
| Oracle JDK | https://www.oracle.com/java/technologies/downloads/ |
| Eclipse Temurin (OpenJDK) | https://adoptium.net/ |
| Amazon Corretto | https://aws.amazon.com/corretto/ |

Run the installer for your platform and follow the on-screen instructions.
You do not need to set `JAVA_HOME` manually — IntelliJ IDEA detects installed
JDKs automatically.

---

### Step 2 — Install IntelliJ IDEA

1. Go to https://www.jetbrains.com/idea/download/
2. Download **IntelliJ IDEA Community Edition** (free) for your platform.
3. Run the installer and follow the on-screen instructions.
4. Launch IntelliJ IDEA after installation.

---

### Step 3 — Open the Project

1. On the **Welcome screen**, click **Open** (or go to **File → Open**).
2. Navigate to the `student-course-management-system` folder (the one that
   contains `src/` and `README.md`).
3. Select that folder and click **OK** / **Open**.
4. If prompted *"Trust and open project?"*, click **Trust Project**.

---

### Step 4 — Configure the Project SDK

1. Go to **File → Project Structure** (shortcut: `Ctrl+Alt+Shift+S` on
   Windows/Linux, `⌘ ;` on macOS).
2. Under **Project Settings → Project**, click the **SDK** dropdown.
3. If a JDK is already listed, select it and click **OK**.
4. If the list is empty, click **Add SDK → JDK** and browse to your JDK
   installation directory, then click **OK**.
5. Set the **Language Level** to **17** (or whichever JDK version you chose).
6. Click **Apply**, then **OK**.

---

### Step 5 — Mark the Source Root

1. Go to **File → Project Structure → Modules**.
2. In the **Sources** tab, find the `src` folder in the tree on the right.
3. Click the `src` folder once, then click the **Sources** button (blue folder
   icon) at the top to mark it as a source root. The folder turns blue.
4. Click **Apply**, then **OK**.

---

### Step 6 — Run the Application

1. In the **Project** panel on the left, expand:
   `src → com → airtribe → learntrack → ui`
2. Right-click on **`Main.java`** and select
   **Run 'Main.main()'**.
3. The **Run** panel opens at the bottom of the screen. You will see:

```
========================================
   Welcome to LearnTrack
========================================
----------------------------------------
  Main Menu
----------------------------------------
  1. Student Management
  2. Course Management
  3. Enrollment Management
  0. Exit
----------------------------------------
Enter choice:
```

4. Click inside the Run panel and type your menu choices.

---

### Step 7 — Run the "Hello, World!" Verification (optional)

To confirm your JDK is working correctly:

1. Go to **File → New → Java Class**.
2. Name it `HelloWorld` and press **Enter**.
3. Replace the generated content with:

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

4. Right-click the file and select **Run 'HelloWorld.main()'**.
5. The Run panel should show:

```
Hello, World!
```

---

### Keyboard Shortcuts Reference

| Action | Windows / Linux | macOS |
|---|---|---|
| Open Project Structure | `Ctrl + Alt + Shift + S` | `⌘ ;` |
| Run current file | `Shift + F10` | `^ R` |
| Search everywhere | `Shift Shift` | `Shift Shift` |
| Reformat code | `Ctrl + Alt + L` | `⌘ ⌥ L` |
| Open terminal inside IDE | `Alt + F12` | `⌥ F12` |
