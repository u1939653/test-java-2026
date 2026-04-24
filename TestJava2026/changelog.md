# Changelog

## [2.0.0] - 2026-04-24
### Added
- Indexes added to the database for improved query performance
- Added files to `.gitignore`
- Added empty result test

### Changed
- Increased efficiency of `GET /prices` endpoint by refactoring query and deleting excess code
- GET endpoint `brandId` + `productId` inputs changed from Query Parameters to Path Variables (more RESTful)

### Fixed
- Solving SOLID principle issues

## [1.0.0] - 2026-04-23
### Added
- Added project info in README
- First version of the project that meets all requirements

## [0.0.2] - 2026-04-22
### Added
- Domain: created `Price` entity and empty Service
- Adapter: created `Prices` Controller with GET endpoint
- Adapter: created `Price` entity and empty repository
- First draft at a GET endpoint to return current price for a given brand, product and date
- Implemented Controller tests
- Increased log level to INFO

### Fixed
- Fixed testing dependencies

### Changed
- Hidden SQL logs

## [0.0.1] - 2026-04-20
### Added
- Build basic runnable SpringBoot server
- Created health check endpoint
- Added h2 dependency and configuration for in-memory database
- Created `.sql` resource files to create and populate PRICES table
- Added h2 console (disabled by default)