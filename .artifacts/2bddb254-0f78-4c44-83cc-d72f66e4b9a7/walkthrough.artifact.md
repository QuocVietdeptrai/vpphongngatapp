# Walkthrough - Splash Screen with Centered Logo

I have successfully added a Splash Screen that displays the VPP Hồng Ngát logo centered when the app starts, before automatically navigating to the Login screen.

## Changes

### 🚀 Splash Screen Feature
- **`activity_splash.xml`**: Created a clean layout centering the logo (`@drawable/logo`), app title ("HỒNG NGÁT"), and subtitle ("Văn phòng phẩm - Đồng hành cùng bạn").
- **`SplashActivity.java`**: Implemented a 1.5-second timer (`Handler`) that smoothly transitions from the splash screen to `LoginActivity` and finishes `SplashActivity`.
- **`AndroidManifest.xml`**: Configured `SplashActivity` as the MAIN/LAUNCHER entry point activity.

## Verification Results

### Automated Tests
- **Gradle Build**: Ran `app:assembleDebug` successfully without errors.
  ```json
  {
    "status": "Build finished successfully."
  }
  ```
