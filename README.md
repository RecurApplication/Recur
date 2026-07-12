# Recur

A mobile application for managing active subscriptions. Lets you add, edit, remove, and reorder your subscriptions.

## Tech Stack
* Jetpack Compose
* Android Room
* Material 3 Expressive
* Kotlin

## Features
* Ordering subscriptions on users way
* Sorting subscriptions based on categories
* Support for daily, weekly, monthly, quarterly, and yearly billed subscriptions
* Pause and resume your subscriptions
* Notifications for upcoming subscription renewals

## Planned features
* Cross-device synchronization via Google account
* Subscription summary with cost calculations

## Getting Started

### Requirements
* Android Studio (latest stable release)
* JDK 11
* Android SDK with platform 36 installed
* An emulator or device running Android 10 (API 29) or higher

### Build & Run
Clone the repository and open it in Android Studio, or build from the command line:

```bash
./gradlew assembleDebug
```

To install the debug build on a connected device or emulator:

```bash
./gradlew installDebug
```

### Tests
```bash
./gradlew test            # unit tests
./gradlew connectedCheck  # instrumented tests (requires a device/emulator)
```

