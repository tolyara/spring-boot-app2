package com.springboot.app2.wiki.testing;

/**
 *
 * https://circleci.com/blog/unit-testing-vs-integration-testing/#:~:text=While%20unit%20tests%20always%20take,works%20in%20an%20integrated%20way.
 *
 * Unit tests focus on one part of an application in total isolation.
 * Execution speed is one of the key benefits of unit testing. These tests should be free from side effects, so you can run them directly without involving any other system.
 * This should include no dependencies on the underlying operating system, such as file system access or network capabilities.
 *
 * While unit tests always take results from a single unit, such as a function call, integration tests may aggregate results from various parts and sources.
 *
 * In an integration test, there is no need to mock away parts of the application. You can replace external systems, but the application works in an integrated way.
 * This approach can be useful for verification in a CI/CD pipeline.
 *
 */
public class TestingUnitVsIntegration {
}
