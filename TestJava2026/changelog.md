# Version 0.0.1
## Phase 1 - Environment preparation
- Build basic runnable SpringBoot server
- Created health check endpoint

## Phase 2 - Create and populate database
- Added h2 dependency and configuration for in-memory database
- Created .sql resource files to create and populate PRICES table
- Added h2 console to check contents (disabled by default)

# Version 0.0.2
## Phase 3 - Implement GET endpoint
- Domain: created Price entity and empty Service
- Adapter: created Prices Controller with GET endpoint
- Adapter: created Price entity and empty repository
- First draft at a GET endpoint to return current price for a given brand, product and date
- Endpoint tested by hand, added some debug logs
- Increased log level to INFO, hidden SQL logs

## Phase 4 - Implement Controller Tests
- Fixed testing dependencies
- Implemented Controller tests

# Version 1.0.0
## Phase 5 - Documentation
- Added project info in README