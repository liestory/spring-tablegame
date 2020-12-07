class AppRouting extends React.Component<> {


    render() {
        return (
            <App>
                <Switch>
                    <Route path={RoutePath.LOGIN_PAGE} component={LoginPage}/>
                    <Route path={RoutePath.ROOT} component={CommunicationsSectionPage} exact/>
                    <Route path={RoutePath.REGISTRATION} component={RegistrationPage} exact/>
                    <Route path={RoutePath.ROOT} component={CommunicationsSectionPage} exact/>
                    <ProtectedRoute path={RoutePath.ADMIN} component={AdminSectionPage}/>

                    <Route component={NoMatch}/>
                </Switch>
            </App>
        );
    }
}


ReactDOM.render(
    <Provider store={store as any}>
        <ConnectedRouter history={history}>
            <AppRoutingContainer/>
        </ConnectedRouter>
    </Provider>,
    document.getElementById("app")
);