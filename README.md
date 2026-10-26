# Coffee Track
An English-language, offline Android café management game for the GMS 4039 mock midterm.

## Play
Choose a customer, tap the matching menu items, then serve. Each of three days lasts 60 seconds. Days 2 and 3 bring two-item orders and less patient customers. Eight illustrated food/drink choices, six customers, an illustrated café, and three purchasable upgrades.

- Correct order: 100 points plus 25 per previous combo step, capped at +100.
- Revenue: menu prices plus a speed-based tip of up to $6.
- Incorrect tray: -20 points; lost customer: -30 points. Score cannot go below zero.
- Espresso machine ($100): +$2 per item; décor ($80): +8 seconds patience; counter ($140): four simultaneous customers.
- Progress saves locally after rewards, penalties, upgrades and completed days. An interrupted day restarts, keeping rewards already earned.

## Run in a browser
Serve `app/src/main/assets` with a local HTTP server. This is a browser preview, not evidence of an Android emulator.

## Android build
Requires JDK 17, Gradle 8.9 and Android SDK platform 35. Run `gradle assembleDebug` from this directory. The GitHub Actions workflow builds and uploads the debug APK on each push. Download Coffee-Track-APK from the completed run.

Android 6+ supported; targets API 28 for consistent full-screen inset behaviour. All assets are packaged locally. No internet permission, accounts, analytics, external images, or remote fonts.

## Submission evidence
Use this game's own repository, its successful Actions run, and an actual Android emulator recording/screenshots. Do not reuse NutriPlate evidence. The Word submission should contain the repository URL, successful build screenshot, and YouTube recording URL (or emulator screenshots when video is unavailable).

Visuals are original CSS and SVG artwork with system-rendered emoji. No third-party image assets are required.
