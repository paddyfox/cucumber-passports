package kainos.specs.site.page_objects;

import kainos.specs.environment.ProductEnvironmentConfiguration;
import kainos.specs.site.Site;

/**
 * Any Page which you want to open should implement this interface to allow it to run on different environments.
 */
public interface OpenablePage {

    String getPagePath();

    default void openPage() {
        Site.goToUrl(ProductEnvironmentConfiguration.getWithDefault().getAppBaseUrl() + this.getPagePath());
    }

}
