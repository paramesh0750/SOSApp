# 🚨 Real-Time Emergency SOS Alert App with Location Sharing

## 📌 Overview

The **Real-Time Emergency SOS Alert App** is an Android-based safety application designed to help users during emergency situations. With a single tap on the SOS button, the app captures the user’s current GPS location and sends it via SMS to a predefined emergency contact.

The application is focused on providing a quick and reliable emergency communication system using Android system services such as Location Services and SMS Manager.

---

# ✨ Features

* 🚨 One-tap SOS emergency alert
* 📍 Real-time GPS location tracking
* 🗺️ Google Maps location link generation
* 📩 SMS alert sending to emergency contact
* 🔐 Runtime permission handling
* 📱 Real-device tested application
* 💾 Local storage support using Room Database

---

# 🛠️ Tech Stack

* **Kotlin**
* **Android Studio**
* **Android SDK**
* **Location Services (GPS)**
* **Fused Location Provider**
* **SMS Manager**
* **Runtime Permissions**
* **Room Database**

---

# 📲 How It Works

1. User clicks the **SEND SOS** button.
2. The app fetches the current GPS location.
3. Latitude and longitude are converted into a Google Maps link.
4. An emergency SMS containing the location link is generated.
5. The SMS is sent to the predefined emergency contact.
6. A confirmation message is displayed to the user.

---

# 📍 Example SOS Message

```text
I am in danger. My location:
https://maps.google.com/?q=17.3850,78.4867
```

---

# 🔐 Permissions Used

The application requires the following Android permissions:

* SEND_SMS
* ACCESS_FINE_LOCATION
* ACCESS_COARSE_LOCATION

These permissions are requested at runtime to ensure user privacy and security.

---

# 📂 Project Structure

```text
app/
 ├── java/com/example/sosapp
 │    ├── MainActivity.kt
 │    ├── Database/
 │    └── Utils/
 ├── res/layout
 ├── AndroidManifest.xml
 └── build.gradle.kts
```

---

# 🧪 Testing

The application was tested on:

* Android Emulator
* Real Android Devices

Test cases verified:

* GPS location fetching
* SMS sending
* Runtime permissions
* Google Maps link generation

---

# ⚠️ Important Note

During development and testing, a personal phone number was initially used to verify SMS functionality.

For security and privacy purposes, the number has been replaced with a dummy testing number:

```text
1234567890
```

Please replace it with your own emergency contact number before running the application.

---

# 🚀 Future Enhancements

* Multiple emergency contacts
* Firebase cloud alerts
* Live location tracking
* Voice emergency alerts
* Call functionality integration
* Improved UI/UX design

---

# 🎯 Learning Outcomes

Through this project, the following concepts were learned:

* Android application development using Kotlin
* GPS-based location tracking
* SMS functionality implementation
* Runtime permission handling
* Real-device testing
* Local data storage using Room Database

---

# 👨‍💻 Author

**Paramesh D**
