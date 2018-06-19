# dagger-sample
A sample of using Dagger over multiple Gradle modules

Features:

- Clear dependency chain `Common` <- `FeatureA` / `FeatureB` <- `App`, i.e. modules know nothing about the app module
- Usable for non-Dagger consumers
- Activity / Fragment injection capabilities built-in
