# Implementation Plan - Splash Screen Logo Only & Expanding Orange Background Animation

This plan updates the Splash Screen (`SplashActivity` & `activity_splash.xml`) to:
1. Display **only** the centered logo (removing text).
2. Add an expanding orange background animation (circular reveal or scale animation) originating from the logo before transitioning to `LoginActivity`.

## Proposed Changes

### UI & Layouts
#### [MODIFY] [activity_splash.xml](file:///C:/DoAnTotNghiep/SalonTocThaiThuy/VppHongNgatApp/app/src/main/res/layout/activity_splash.xml)
- Keep only the centered `ImageView` (`ivSplashLogo`).
- Add an expanding orange background view (`vOrangeBackground`) or scale/reveal layout.

### Animation & Logic
#### [MODIFY] [SplashActivity.java](file:///C:/DoAnTotNghiep/SalonTocThaiThuy/VppHongNgatApp/app/src/main/java/com/example/vpphongngatapp/ui/auth/SplashActivity.java)
- Implement scale and fade/expansion animation on the logo and an expanding background circle view using `ViewPropertyAnimator` or `AnimatorSet`.
- Trigger transition to `LoginActivity` upon animation completion.

## Verification Plan

### Automated Tests
- Run Gradle build task (`app:assembleDebug`) to ensure clean compilation.
